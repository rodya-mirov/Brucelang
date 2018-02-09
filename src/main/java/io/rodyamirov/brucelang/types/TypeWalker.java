package io.rodyamirov.brucelang.types;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BinOpExprNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.ExpressionNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.Typed;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astexceptions.WrongTypeException;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;
import io.rodyamirov.brucelang.util.collections.StackHelper;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static io.rodyamirov.brucelang.types.TypeDeclaration.equalTypes;

public class TypeWalker {
    private TypeWalker() {
    }

    public static void assignAndCheckTypes(ProgramNode programNode) {
        new TypeVisitor().visitProgram(programNode);
    }

    private static <T extends ASTNode & Typed> void setCheckOrThrow(T astNode, TypeDeclaration expectedType) {
        TypeDeclaration actualType = astNode.getType();
        if (actualType == null) {
            astNode.setType(expectedType);
        } else if (!equalTypes(actualType, expectedType)) {
            throw new WrongTypeException(astNode,
                    "Wrong type! Got '%s' but expected '%s'",
                    actualType.toPrettyString(), expectedType.toPrettyString());
        }
    }

    private static <T extends ASTNode & Typed> void checkOrThrow(T astNode, TypeDeclaration expectedType) {
        TypeDeclaration actualType = astNode.getType();
        if (actualType == null) {
            throw new WrongTypeException(astNode, "Type should have already been assigned!");
        } else if (!equalTypes(actualType, expectedType)) {
            throw new WrongTypeException(astNode,
                    "Wrong type! Got '%s' but expected '%s'",
                    actualType.toPrettyString(), expectedType.toPrettyString());
        }
    }

    private static class TypeVisitor implements ASTNode.ASTVisitor {
        private final Stack<AtomicReference<TypeDeclaration>> containingFunctions = new ArrayStack<>();
        private final StackHelper<AtomicReference<TypeDeclaration>> functionHelper = new StackHelper<>(containingFunctions);

        @Override
        public void visitProgram(ProgramNode programNode) {
            programNode.getStatements().forEach(node -> node.accept(this));
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionDefinitionNode) {
            AtomicReference<TypeDeclaration> valueHolster = new AtomicReference<>(null);

            functionHelper.safePushPop(
                    valueHolster,
                    () -> {
                        functionDefinitionNode.getParameterNodes().forEach(node -> node.accept(this));
                        functionDefinitionNode.getDefinitionStatements().forEach(node -> node.accept(this));
                    }
            );

            TypeDeclaration returnType = valueHolster.get();
            if (returnType == null) {
                // TODO: do we want to allow this? Nothing returned, probably an error
                returnType = StandardTypeDeclarations.makeNoneType();
            }

            TypeDeclaration functionType = StandardTypeDeclarations.makeFunctionType(
                    functionDefinitionNode.getParameterNodes().stream()
                            .map(Typed::getType).collect(Collectors.toList()),
                    returnType
            );

            functionDefinitionNode.setType(functionType);
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            variableDefinitionNode.getVariableDeclarationNode().accept(this);
            variableDefinitionNode.getEvalExpr().accept(this);

            TypeDeclaration declaredType = variableDefinitionNode.getVariableDeclarationNode().getType();
            TypeDeclaration actualType = variableDefinitionNode.getEvalExpr().getType();

            if (equalTypes(declaredType, StandardTypeDeclarations.makeInferredType())) {
                variableDefinitionNode.getVariableDeclarationNode().setType(actualType);
            } else {
                checkOrThrow(variableDefinitionNode.getEvalExpr(), declaredType);
            }
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            // just check everything is declared
            if (variableDeclarationNode.getType() == null) {
                throw new WrongTypeException(variableDeclarationNode,
                        "Type should already have been assigned!");
            }
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            blockStatementNode.getStatements().forEach(stmt -> stmt.accept(this));
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            doStatementNode.getEvalExpression().accept(this);
            // TODO: what the hell is a do statement, do we need to typecheck it?
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            returnStatementNode.getEvalExpression().accept(this);
            TypeDeclaration actualType = returnStatementNode.getEvalExpression().getType();

            AtomicReference<TypeDeclaration> returnTypeHolster = containingFunctions.peek();
            TypeDeclaration expectedType = returnTypeHolster.get();

            if (expectedType == null) {
                returnTypeHolster.set(actualType);
            } else if (!equalTypes(expectedType, actualType)) {
                throw new WrongTypeException(returnStatementNode,
                        "Function has seen return types of both '%s' and '%s', inconsistent",
                        actualType.toPrettyString(), expectedType.toPrettyString());
            } // else all good, all consistent
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            // mostly just recursion passing on down
            // only rule is that the conditions need to all type to booleans

            for (ExpressionNode expressionNode : ifStatementNode.getConditions()) {
                expressionNode.accept(this);
                checkOrThrow(expressionNode, StandardTypeDeclarations.makeBooleanType());
            }

            for (StatementNode thenStatment : ifStatementNode.getResultingStatements()) {
                thenStatment.accept(this);
            }

            Optional.ofNullable(ifStatementNode.getElseStatement())
                    .ifPresent(elseStatement -> elseStatement.accept(this));
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            functionCallNode.getFunctionNode().accept(this);
            functionCallNode.getArguments().forEach(arg -> arg.accept(this));

            FunctionTypeWrapper functionType =
                    new FunctionTypeWrapper(functionCallNode.getFunctionNode().getType());

            if (functionType.getArgTypes().size() != functionCallNode.getArguments().size()) {
                throw new WrongTypeException(functionCallNode,
                        "Function expected '%d' arguments but got '%d'",
                        functionType.getArgTypes().size(),
                        functionCallNode.getArguments().size());
            }

            for (int i = 0; i < functionType.getArgTypes().size(); i++) {
                TypeDeclaration expected = functionType.getArgTypes().get(i);
                TypeDeclaration actual = functionCallNode.getArguments().get(i).getType();

                if (!equalTypes(expected, actual)) {
                    throw new WrongTypeException(functionCallNode,
                            "Parameter '%d' to call expected type '%s' but got type '%s'",
                            i, expected.toPrettyString(), actual.toPrettyString());
                }
            }

            functionCallNode.setType(functionType.getReturnType());
        }

        @Override
        public void visitBinOpExprNode(BinOpExprNode binOpExprNode) {
            binOpExprNode.getLeftChild().accept(this);
            binOpExprNode.getRightChild().accept(this);

            TypeDeclaration leftType = binOpExprNode.getLeftChild().getType();
            TypeDeclaration rightType = binOpExprNode.getRightChild().getType();

            TypeDeclaration resultType = binOpExprNode.getOperation()
                    .findOutputType(leftType, rightType);

            if (resultType == null) {
                throw new WrongTypeException(binOpExprNode,
                        "Operation '%s' is not defined for input types '%s' and '%s'",
                        binOpExprNode.getOperation().toString(), leftType.toPrettyString(), rightType.toPrettyString());
            }

            binOpExprNode.setType(resultType);
        }

        @Override
        public void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode) {
            unaryOpExprNode.getChild().accept(this);

            TypeDeclaration childType = unaryOpExprNode.getChild().getType();

            TypeDeclaration resultType = unaryOpExprNode.getOperation()
                    .findOutputType(childType);

            if (resultType == null) {
                throw new WrongTypeException(unaryOpExprNode,
                        "Operation '%s' is not defined for input type '%s'",
                        unaryOpExprNode.getOperation().toString(), childType.toPrettyString());
            }

            unaryOpExprNode.setType(resultType);
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            throw new UnsupportedOperationException(); // no clue! this requires some understanding of what the type IS!
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            TypeDeclaration expected = StandardTypeDeclarations.makeIntegerType();

            setCheckOrThrow(integerNode, expected);
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            TypeDeclaration expected = StandardTypeDeclarations.makeBooleanType();

            setCheckOrThrow(booleanNode, expected);
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            TypeDeclaration expected = StandardTypeDeclarations.makeStringType();

            setCheckOrThrow(stringExprNode, expected);
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            TypeDeclaration expected = variableReferenceNode.getDefinition().getType();

            if (expected == null) {
                throw new WrongTypeException(variableReferenceNode.getDefinition(),
                        "Variable '%s' does not have an associated type!",
                        variableReferenceNode.getDefinition().getCanonicalName());
            }

            setCheckOrThrow(variableReferenceNode, expected);
        }
    }
}
