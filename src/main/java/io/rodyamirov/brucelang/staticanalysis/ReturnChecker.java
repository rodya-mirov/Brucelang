package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
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
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.TypeDeclarationNode;
import io.rodyamirov.brucelang.ast.TypeDefinitionNode;
import io.rodyamirov.brucelang.ast.TypeFieldsNode;
import io.rodyamirov.brucelang.ast.TypeFuncCallNode;
import io.rodyamirov.brucelang.ast.TypeFuncExprNode;
import io.rodyamirov.brucelang.ast.TypeFuncTypeRefNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astexceptions.AstException;
import io.rodyamirov.brucelang.astwalkers.ASTWalker;
import io.rodyamirov.brucelang.astwalkers.Walker;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;

import java.util.concurrent.atomic.AtomicInteger;

public class ReturnChecker {
    private ReturnChecker() {
    }

    public static void checkFunctionsReturn(ProgramNode programNode) {
        new Walker().withWalker(new ReturnWalker()).walkTree(programNode);
        new Walker().withWalker(new ReturnInFunctionWalker()).walkTree(programNode);
    }

    public static class NoReturnException extends AstException {
        public NoReturnException(FunctionExprNode node) {
            super(node, String.format("Not all code paths for '%s' return a value!", node.getFullName()));
        }

        public NoReturnException(TypeFuncExprNode node) {
            super(node, String.format("Not all code paths for '%s' return a value!", node.getFullName()));
        }
    }

    public static class UnreachableCodeException extends AstException {
        public UnreachableCodeException(StatementNode statementNode) {
            super(statementNode, "Unreachable code!");
        }
    }

    public static class ReturnNotInFunctionException extends AstException {
        public ReturnNotInFunctionException(ReturnStatementNode returnStatementNode) {
            super(returnStatementNode, "Return statement was not inside a function definition!");
        }
    }

    // for checking every return actually does occur in a function
    private static class ReturnInFunctionWalker implements ASTWalker {
        private final Stack<AtomicInteger> functionExprNodeStack = new ArrayStack<>();

        private void newFunctionStack(ASTNode ignored) {
            functionExprNodeStack.push(new AtomicInteger(0));
        }

        private void endFunctionStack(ASTNode ignored) {
            functionExprNodeStack.pop();
        }

        @Override
        public void programWalk(WalkFunctions<ProgramNode> walkFunctions) {
            walkFunctions.preWalker(this::newFunctionStack);
            walkFunctions.postWalker(this::endFunctionStack);
        }

        @Override
        public void typeFuncWalk(WalkFunctions<TypeFuncExprNode> walkFunctions) {
            walkFunctions.preWalker(func -> functionExprNodeStack.peek().getAndIncrement());
            walkFunctions.postWalker(functionExprNode -> functionExprNodeStack.peek().getAndDecrement());
        }

        @Override
        public void typeFieldsWalk(WalkFunctions<TypeFieldsNode> walkFunctions) {
            walkFunctions.preWalker(this::newFunctionStack);
            walkFunctions.postWalker(this::endFunctionStack);
        }

        @Override
        public void returnWalk(WalkFunctions<ReturnStatementNode> walkFunctions) {
            walkFunctions.preWalker(returnStatementNode -> {
                if (functionExprNodeStack.peek().get() == 0) {
                    throw new ReturnNotInFunctionException(returnStatementNode);
                }
            });
        }

        @Override
        public void functionExprWalk(WalkFunctions<FunctionExprNode> walkFunctions) {
            walkFunctions.preWalker(func -> functionExprNodeStack.peek().getAndIncrement());
            walkFunctions.postWalker(functionExprNode -> functionExprNodeStack.peek().getAndDecrement());
        }

        // most nodes have nothing to do with this check ....
        @Override
        public void typeFuncCallWalk(WalkFunctions<TypeFuncCallNode> walkFunctions) {
        }

        @Override
        public void typeFuncRefWalk(WalkFunctions<TypeFuncTypeRefNode> walkFunctions) {
        }

        @Override
        public void nativeVarDefWalk(WalkFunctions<NativeVarDefNode> walkFunctions) {
        }

        @Override
        public void typeDefnWalk(WalkFunctions<TypeDefinitionNode> walkFunctions) {
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
        public void funcTypeRefWalk(WalkFunctions<FunctionTypeReferenceNode> walkFunctions) {
        }

        @Override
        public void varDefnWalk(WalkFunctions<VariableDefinitionNode> walkFunctions) {
        }

        @Override
        public void varDeclWalk(WalkFunctions<VariableDeclarationNode> walkFunctions) {
        }

        @Override
        public void doWalk(WalkFunctions<DoStatementNode> walkFunctions) {
        }

        @Override
        public void fnCallWalk(WalkFunctions<FunctionCallNode> walkFunctions) {
        }

        @Override
        public void ifStmtWalk(WalkFunctions<IfStatementNode> walkFunctions) {
        }

        @Override
        public void fieldAccessWalk(WalkFunctions<FieldAccessNode> walkFunctions) {
        }

        @Override
        public void intExprWalk(WalkFunctions<IntExprNode> walkFunctions) {
        }

        @Override
        public void boolExprWalk(WalkFunctions<BoolExprNode> walkFunctions) {
        }

        @Override
        public void stringExprWalk(WalkFunctions<StringExprNode> walkFunctions) {
        }

        @Override
        public void varRefWalk(WalkFunctions<VariableReferenceNode> walkFunctions) {
        }

        @Override
        public void blockStmtWalk(WalkFunctions<BlockStatementNode> walkFunctions) {
        }
    }

    // for finding which nodes actually do return, to see if every code path returns
    private static class ReturnWalker implements ASTWalker {
        private void doesNotReturn(StatementNode statementNode) {
            statementNode.setReturns(false);
        }

        private void doesReturn(StatementNode statementNode) {
            statementNode.setReturns(true);
        }

        @Override
        public void programWalk(WalkFunctions<ProgramNode> walkFunctions) {
        }

        @Override
        public void typeFuncRefWalk(WalkFunctions<TypeFuncTypeRefNode> walkFunctions) {
        }

        @Override
        public void typeFuncWalk(WalkFunctions<TypeFuncExprNode> walkFunctions) {
            walkFunctions.postWalker(typeFuncExprNode -> {
                boolean doesReturn = false;

                for (StatementNode statementNode : typeFuncExprNode.getDefinitionStatements()) {
                    if (doesReturn) {
                        // best-effort unreachable code catching
                        throw new UnreachableCodeException(statementNode);
                    }

                    doesReturn = statementNode.doesReturn();
                }

                if (!doesReturn) {
                    throw new NoReturnException(typeFuncExprNode);
                }
            });
        }

        @Override
        public void typeFuncCallWalk(WalkFunctions<TypeFuncCallNode> walkFunctions) {
        }

        @Override
        public void nativeVarDefWalk(WalkFunctions<NativeVarDefNode> walkFunctions) {
            walkFunctions.preWalker(this::doesNotReturn);
        }

        @Override
        public void typeDefnWalk(WalkFunctions<TypeDefinitionNode> walkFunctions) {
            walkFunctions.preWalker(this::doesNotReturn);
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
        public void funcTypeRefWalk(WalkFunctions<FunctionTypeReferenceNode> walkFunctions) {
        }

        @Override
        public void functionExprWalk(WalkFunctions<FunctionExprNode> walkFunctions) {
            walkFunctions.postWalker(functionExprNode -> {
                boolean doesReturn = false;

                for (StatementNode statementNode : functionExprNode.getDefinitionStatements()) {
                    if (doesReturn) {
                        throw new UnreachableCodeException(statementNode);
                    }

                    doesReturn = statementNode.doesReturn();
                }

                if (!doesReturn) {
                    throw new NoReturnException(functionExprNode);
                }
            });
        }

        @Override
        public void varDefnWalk(WalkFunctions<VariableDefinitionNode> walkFunctions) {
            walkFunctions.postWalker(this::doesNotReturn);
        }

        @Override
        public void varDeclWalk(WalkFunctions<VariableDeclarationNode> walkFunctions) {
        }

        @Override
        public void returnWalk(WalkFunctions<ReturnStatementNode> walkFunctions) {
            walkFunctions.postWalker(this::doesReturn);
        }

        @Override
        public void doWalk(WalkFunctions<DoStatementNode> walkFunctions) {
            walkFunctions.postWalker(this::doesNotReturn);
        }

        @Override
        public void fnCallWalk(WalkFunctions<FunctionCallNode> walkFunctions) {
        }

        @Override
        public void ifStmtWalk(WalkFunctions<IfStatementNode> walkFunctions) {
            walkFunctions.postWalker(ifStatementNode -> {
                if (ifStatementNode.getElseStatement() == null) {
                    doesNotReturn(ifStatementNode);
                } else {
                    boolean didReturn = ifStatementNode.getElseStatement().doesReturn();

                    for (StatementNode thenStmt : ifStatementNode.getResultingStatements()) {
                        didReturn &= thenStmt.doesReturn();
                    }

                    ifStatementNode.setReturns(didReturn);
                }
            });
        }

        @Override
        public void fieldAccessWalk(WalkFunctions<FieldAccessNode> walkFunctions) {
        }

        @Override
        public void intExprWalk(WalkFunctions<IntExprNode> walkFunctions) {
        }

        @Override
        public void boolExprWalk(WalkFunctions<BoolExprNode> walkFunctions) {
        }

        @Override
        public void stringExprWalk(WalkFunctions<StringExprNode> walkFunctions) {
        }

        @Override
        public void varRefWalk(WalkFunctions<VariableReferenceNode> walkFunctions) {
        }

        @Override
        public void blockStmtWalk(WalkFunctions<BlockStatementNode> walkFunctions) {
            walkFunctions.postWalker(blockStatementNode -> {
                boolean didReturn = false;

                for (StatementNode child : blockStatementNode.getStatements()) {
                    if (didReturn) {
                        throw new UnreachableCodeException(child);
                    }

                    didReturn = child.doesReturn();
                }

                blockStatementNode.setReturns(didReturn);
            });
        }
    }
}
