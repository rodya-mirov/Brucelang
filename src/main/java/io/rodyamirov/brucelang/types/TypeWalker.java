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
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.Typed;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astexceptions.WrongOrderException;
import io.rodyamirov.brucelang.astexceptions.WrongTypeException;
import io.rodyamirov.brucelang.astwalkers.ASTWalker;
import io.rodyamirov.brucelang.astwalkers.Walker;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static io.rodyamirov.brucelang.types.TypeDeclaration.equalTypes;

public class TypeWalker {
    private TypeWalker() {
    }

    public static void assignAndCheckTypes(ProgramNode programNode) {
        new Walker().withWalker(new TypeWalkerHelper()).walkTree(programNode);
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

    private static class TypeWalkerHelper implements ASTWalker {
        private final Stack<AtomicReference<TypeDeclaration>> containingFunctions = new ArrayStack<>();

        @Override
        public void programWalk(WalkFunctions<ProgramNode> walkFunctions) {
        }

        @Override
        public void functionExprWalk(WalkFunctions<FunctionExprNode> walkFunctions) {
            walkFunctions.preWalker(functionExprNode -> {
                containingFunctions.push(new AtomicReference<>(null));
            });

            walkFunctions.postWalker(functionExprNode -> {
                TypeDeclaration returnedType = containingFunctions.pop().get();
                if (returnedType == null) {
                    throw new WrongOrderException(functionExprNode,
                            "It should have been checked that all code paths return a value!");
                }

                TypeDeclaration functionType = StandardTypeDeclarations.makeFunctionType(
                        functionExprNode.getParameterNodes().stream()
                                .map(Typed::getType).collect(Collectors.toList()),
                        returnedType
                );

                functionExprNode.setType(functionType);
            });
        }

        @Override
        public void varDefnWalk(WalkFunctions<VariableDefinitionNode> walkFunctions) {
            walkFunctions.postWalker(variableDefinitionNode -> {
                TypeDeclaration declaredType = variableDefinitionNode
                        .getVariableDeclarationNode().getType();

                TypeDeclaration actualType = variableDefinitionNode.getEvalExpr().getType();
                if (equalTypes(declaredType, StandardTypeDeclarations.makeInferredType())) {
                    variableDefinitionNode.getVariableDeclarationNode().setType(actualType);
                } else {
                    checkOrThrow(variableDefinitionNode.getEvalExpr(), declaredType);
                }
            });
        }

        @Override
        public void varDeclWalk(WalkFunctions<VariableDeclarationNode> walkFunctions) {
        }

        @Override
        public void returnWalk(WalkFunctions<ReturnStatementNode> walkFunctions) {
            walkFunctions.postWalker(returnStatementNode -> {
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
            });
        }

        @Override
        public void doWalk(WalkFunctions<DoStatementNode> walkFunctions) {
        }

        @Override
        public void fnCallWalk(WalkFunctions<FunctionCallNode> walkFunctions) {
            walkFunctions.postWalker(functionCallNode -> {
                FunctionTypeWrapper functionType = new FunctionTypeWrapper(functionCallNode.getFunctionNode().getType());

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
            });
        }

        @Override
        public void ifStmtWalk(WalkFunctions<IfStatementNode> walkFunctions) {
            TypeDeclaration booleanType = StandardTypeDeclarations.makeBooleanType();

            walkFunctions.postWalker(ifStatementNode -> {
                for (ExpressionNode expressionNode : ifStatementNode.getConditions()) {
                    checkOrThrow(expressionNode, booleanType);
                }
            });
        }

        @Override
        public void binOpWalk(WalkFunctions<BinOpExprNode> walkFunctions) {
            walkFunctions.postWalker(binOpExprNode -> {
                TypeDeclaration leftType = binOpExprNode.getLeftChild().getType();
                TypeDeclaration rightType = binOpExprNode.getRightChild().getType();

                TypeDeclaration output = binOpExprNode.getOperation().findOutputType(leftType, rightType);
                if (output == null) {
                    throw new WrongTypeException(binOpExprNode,
                            "Operation '%s' is not defined for input types '%s' and '%s'",
                            binOpExprNode.getOperation().toString(), leftType.toPrettyString(), rightType.toPrettyString());
                }
                binOpExprNode.setType(output);
            });
        }

        @Override
        public void unaryOpWalk(WalkFunctions<UnaryOpExprNode> walkFunctions) {
            walkFunctions.postWalker(unaryOpExprNode -> {
                TypeDeclaration childType = unaryOpExprNode.getChild().getType();

                TypeDeclaration output = unaryOpExprNode.getOperation().findOutputType(childType);
                if (output == null) {
                    throw new WrongTypeException(unaryOpExprNode,
                            "Operation '%s' is not defined for input type '%s'",
                            unaryOpExprNode.getOperation().toString(), childType.toPrettyString());
                }
                unaryOpExprNode.setType(output);
            });
        }

        @Override
        public void fieldAccessWalk(WalkFunctions<FieldAccessNode> walkFunctions) {
            RuntimeException fml = new RuntimeException("I didn't deal with field accesses yet");
            walkFunctions.preWalker(fieldAccessNode -> { throw fml; });
            walkFunctions.postWalker(fieldAccessNode -> { throw fml; });
        }

        @Override
        public void intExprWalk(WalkFunctions<IntExprNode> walkFunctions) {
            walkFunctions.preWalker(intExprNode -> intExprNode.setType(StandardTypeDeclarations.makeIntegerType()));
        }

        @Override
        public void boolExprWalk(WalkFunctions<BoolExprNode> walkFunctions) {
            walkFunctions.preWalker(boolExprNode -> boolExprNode.setType(StandardTypeDeclarations.makeBooleanType()));
        }

        @Override
        public void stringExprWalk(WalkFunctions<StringExprNode> walkFunctions) {
            walkFunctions.preWalker(stringExprNode -> stringExprNode.setType(StandardTypeDeclarations.makeStringType()));
        }

        @Override
        public void varRefWalk(WalkFunctions<VariableReferenceNode> walkFunctions) {
            walkFunctions.preWalker(variableReferenceNode -> {
                VariableDeclarationNode referee = variableReferenceNode.getDefinition();
                variableReferenceNode.setType(referee.getType());
            });
        }

        @Override
        public void blockStmtWalk(WalkFunctions<BlockStatementNode> walkFunctions) {
        }
    }
}
