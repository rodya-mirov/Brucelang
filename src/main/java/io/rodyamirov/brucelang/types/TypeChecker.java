package io.rodyamirov.brucelang.types;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.ExpressionNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FieldDeclarationNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.FunctionTypeReferenceNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.NativeVarDefNode;
import io.rodyamirov.brucelang.ast.ParametrizedTypeReferenceNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.SimpleTypeReferenceNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.TypeDeclarationNode;
import io.rodyamirov.brucelang.ast.TypeDefinitionNode;
import io.rodyamirov.brucelang.ast.TypeFieldsNode;
import io.rodyamirov.brucelang.ast.TypeFuncCallNode;
import io.rodyamirov.brucelang.ast.TypeFuncExprNode;
import io.rodyamirov.brucelang.ast.TypeFuncTypeRefNode;
import io.rodyamirov.brucelang.ast.TypeReferenceNode;
import io.rodyamirov.brucelang.ast.Typed;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astexceptions.WrongOrderException;
import io.rodyamirov.brucelang.astexceptions.WrongTypeException;
import io.rodyamirov.brucelang.astwalkers.ASTWalker;
import io.rodyamirov.brucelang.astwalkers.Walker;
import io.rodyamirov.brucelang.staticanalysis.TreePrinter;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static io.rodyamirov.brucelang.ast.TypeReferenceNode.equalTypes;

public class TypeChecker {
    private TypeChecker() {
    }

    /**
     * Get working TypeReferences for every ExpressionNode, and check compatibility with constraints:
     * - Declared types
     * - Type definitions (for field accesses)
     * - Function compatibility (for function calls)
     * - Operator compatibility (e.g. you can only add integers)
     *
     * @param programNode Program to be type checked
     */
    public static void assignAndCheckTypes(ProgramNode programNode) {
        new Walker().withWalker(new TypeCheckerWalker()).walkTree(programNode);
    }

    private static <T extends ASTNode & Typed> void checkOrThrow(T astNode, TypeReferenceNode expectedType) {
        TypeReferenceNode actualType = astNode.getType();
        if (actualType == null) {
            throw new WrongTypeException(astNode, "Type should have already been assigned!");
        } else if (!equalTypes(actualType, expectedType)) {
            throw new WrongTypeException(astNode,
                    "Wrong type! Got '%s' but expected '%s'",
                    TreePrinter.printTree(actualType, true),
                    TreePrinter.printTree(expectedType, true));
        }
    }

    private static class TypeCheckerWalker implements ASTWalker {
        private final Stack<AtomicReference<TypeReferenceNode>> containingFunctions = new ArrayStack<>();

        @Override
        public void programWalk(WalkFunctions<ProgramNode> walkFunctions) {
        }

        @Override
        public void nativeVarDefWalk(WalkFunctions<NativeVarDefNode> walkFunctions) {
        }

        @Override
        public void functionExprWalk(WalkFunctions<FunctionExprNode> walkFunctions) {
            walkFunctions.preWalker(functionExprNode -> {
                containingFunctions.push(new AtomicReference<>(null));
            });

            walkFunctions.postWalker(functionExprNode -> {
                TypeReferenceNode returnedType = containingFunctions.pop().get();
                if (returnedType == null) {
                    throw new WrongOrderException(functionExprNode,
                            "It should have been checked that all code paths return a value!");
                }

                TypeReferenceNode functionType = StandardTypeReferences.makeFunctionType(
                        functionExprNode.getParameterNodes().stream()
                                .map(Typed::getType).collect(Collectors.toList()),
                        returnedType,
                        functionExprNode.getNamespace()
                );

                functionExprNode.setType(functionType);
            });
        }

        @Override
        public void typeFuncWalk(WalkFunctions<TypeFuncExprNode> walkFunctions) {
            walkFunctions.preWalker(typeFuncExprNode -> {
                containingFunctions.push(new AtomicReference<>(null));
            });

            walkFunctions.postWalker(typeFuncExprNode -> {
                TypeReferenceNode returnedType = containingFunctions.pop().get();
                if (returnedType == null) {
                    throw new WrongOrderException(typeFuncExprNode,
                            "It should have been checked that all code paths return a value!");
                }

                TypeReferenceNode typeReferenceNode = StandardTypeReferences.makeTypeFunctionType(
                        typeFuncExprNode.getTypeParameters(),
                        returnedType,
                        typeFuncExprNode.getChildNamespace()
                );

                typeFuncExprNode.setType(typeReferenceNode);
            });
        }

        @Override
        public void typeFuncCallWalk(WalkFunctions<TypeFuncCallNode> walkFunctions) {
            walkFunctions.postWalker(typeFuncCallNode -> {
                TypeReferenceNode baseType = typeFuncCallNode.getBaseNode().getType();
                if (!(baseType instanceof TypeFuncTypeRefNode)) {
                    throw new WrongTypeException(typeFuncCallNode,
                            "Gave type parameters to an expression of type '%s', "
                                    + "which is not a type function!",
                            TreePrinter.printTree(baseType, true));
                }

                TypeReferenceNode evaluated = TypeEvaluator.evaluate(
                        (TypeFuncTypeRefNode) baseType,
                        typeFuncCallNode.getTypeArguments());

                typeFuncCallNode.setType(evaluated);
            });
        }

        @Override
        public void varDefnWalk(WalkFunctions<VariableDefinitionNode> walkFunctions) {
            walkFunctions.postWalker(variableDefinitionNode -> {
                TypeReferenceNode declaredType = variableDefinitionNode
                        .getVariableDeclarationNode().getType();

                TypeReferenceNode actualType = variableDefinitionNode.getEvalExpr().getType();
                if (declaredType == null) {
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
                TypeReferenceNode actualType = returnStatementNode.getEvalExpression().getType();

                AtomicReference<TypeReferenceNode> returnTypeHolster = containingFunctions.peek();
                TypeReferenceNode expectedType = returnTypeHolster.get();

                if (expectedType == null) {
                    returnTypeHolster.set(actualType);
                } else if (!equalTypes(expectedType, actualType)) {
                    throw new WrongTypeException(returnStatementNode,
                            "Function has seen return types of both '%s' and '%s', inconsistent",
                            TreePrinter.printTree(actualType, true),
                            TreePrinter.printTree(expectedType, true));
                } // else all good, all consistent
            });
        }

        @Override
        public void doWalk(WalkFunctions<DoStatementNode> walkFunctions) {
        }

        @Override
        public void fnCallWalk(WalkFunctions<FunctionCallNode> walkFunctions) {
            walkFunctions.postWalker(functionCallNode -> {
                TypeReferenceNode baseType = functionCallNode.getFunctionNode().getType();
                if (!(baseType instanceof FunctionTypeReferenceNode)) {
                    throw new WrongTypeException(functionCallNode,
                            "Cannot 'call' a value of type '%s'",
                            TreePrinter.printTree(baseType, true));
                }

                // TODO: is there a way to avoid downcasting? This is brittle wrt changing our class structure
                FunctionTypeReferenceNode functionType = (FunctionTypeReferenceNode) baseType;

                int numFuncArgs = functionType.getArguments().size();
                if (numFuncArgs != functionCallNode.getArguments().size()) {
                    throw new WrongTypeException(functionCallNode,
                            "Function expected '%d' arguments but got '%d'",
                            functionType.getArguments().size(),
                            functionCallNode.getArguments().size());
                }

                for (int i = 0; i < numFuncArgs; i++) {
                    TypeReferenceNode expected = functionType.getArguments().get(i);
                    TypeReferenceNode actual = functionCallNode.getArguments().get(i).getType();

                    if (!equalTypes(expected, actual)) {
                        throw new WrongTypeException(functionCallNode,
                                "Parameter '%d' to call expected type '%s' but got type '%s'",
                                i,
                                TreePrinter.printTree(expected, true),
                                TreePrinter.printTree(actual, true));
                    }
                }

                functionCallNode.setType(functionType.getReturnType());
            });
        }

        @Override
        public void typeDefnWalk(WalkFunctions<TypeDefinitionNode> walkFunctions) {
        }

        @Override
        public void typeFieldsWalk(WalkFunctions<TypeFieldsNode> walkFunctions) {
        }

        @Override
        public void fieldDeclWalk(WalkFunctions<FieldDeclarationNode> walkFunctions) {
        }

        @Override
        public void typeDeclWalk(WalkFunctions<TypeDeclarationNode> walkFunctions) {
        }

        @Override
        public void simpleTypeRefWalk(WalkFunctions<SimpleTypeReferenceNode> walkFunctions) {
        }

        @Override
        public void parTypeRefWalk(WalkFunctions<ParametrizedTypeReferenceNode> walkFunctions) {
        }

        @Override
        public void typeFuncRefWalk(WalkFunctions<TypeFuncTypeRefNode> walkFunctions) {
        }

        @Override
        public void funcTypeRefWalk(WalkFunctions<FunctionTypeReferenceNode> walkFunctions) {
        }

        @Override
        public void ifStmtWalk(WalkFunctions<IfStatementNode> walkFunctions) {
            walkFunctions.postWalker(ifStatementNode -> {
                for (ExpressionNode expressionNode : ifStatementNode.getConditions()) {
                    checkOrThrow(expressionNode, StandardTypeReferences.makeBooleanType(expressionNode.getNamespace()));
                }
            });
        }

        @Override
        public void fieldAccessWalk(WalkFunctions<FieldAccessNode> walkFunctions) {
            walkFunctions.postWalker(fieldAccessNode -> {
                TypeReferenceNode baseType = fieldAccessNode.getBaseNode().getType();
                TypeFieldsNode typeDef = fieldAccessNode.getTypeRegistry().getDefinition(baseType);
                FieldDeclarationNode field = typeDef.getField(fieldAccessNode.getFieldName());
                fieldAccessNode.setType(field.getType());
            });
        }

        @Override
        public void intExprWalk(WalkFunctions<IntExprNode> walkFunctions) {
            walkFunctions.preWalker(intExprNode -> {
                intExprNode.setType(StandardTypeReferences.makeIntegerType(intExprNode.getNamespace()));
            });
        }

        @Override
        public void boolExprWalk(WalkFunctions<BoolExprNode> walkFunctions) {
            walkFunctions.preWalker(boolExprNode -> {
                boolExprNode.setType(StandardTypeReferences.makeBooleanType(boolExprNode.getNamespace()));
            });
        }

        @Override
        public void stringExprWalk(WalkFunctions<StringExprNode> walkFunctions) {
            walkFunctions.preWalker(stringExprNode -> {
                stringExprNode.setType(StandardTypeReferences.makeStringType(stringExprNode.getNamespace()));
            });
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
