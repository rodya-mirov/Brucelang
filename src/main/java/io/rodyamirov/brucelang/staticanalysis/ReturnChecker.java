package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.BinOpExprNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astexceptions.AstException;
import io.rodyamirov.brucelang.astwalkers.ASTWalker;
import io.rodyamirov.brucelang.astwalkers.DefaultASTWalker;
import io.rodyamirov.brucelang.astwalkers.Walker;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;

public class ReturnChecker {
    private ReturnChecker() {
    }

    public static void checkFunctionsReturn(ProgramNode programNode) {
        new Walker().withWalker(new ReturnWalker()).walkTree(programNode);
        new Walker().withWalker(new ReturnInFunctionWalker()).walkTree(programNode);
    }

    public static class NoReturnException extends AstException {
        public NoReturnException(FunctionExprNode node) {
            super(node, String.format("Not all code paths for '%s' return a value!", node.getCanonicalName()));
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

    private static class ReturnInFunctionWalker extends DefaultASTWalker {
        private final Stack<FunctionExprNode> functionExprNodeStack = new ArrayStack<>();

        @Override
        public void returnWalk(WalkFunctions<ReturnStatementNode> walkFunctions) {
            walkFunctions.preWalker(returnStatementNode -> {
                if (functionExprNodeStack.size() == 0) {
                    throw new ReturnNotInFunctionException(returnStatementNode);
                }
            });
        }

        @Override
        public void functionExprWalk(WalkFunctions<FunctionExprNode> walkFunctions) {
            walkFunctions.preWalker(functionExprNodeStack::push);
            walkFunctions.postWalker(functionExprNode -> functionExprNodeStack.pop());
        }
    }

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
        public void binOpWalk(WalkFunctions<BinOpExprNode> walkFunctions) {
        }

        @Override
        public void unaryOpWalk(WalkFunctions<UnaryOpExprNode> walkFunctions) {
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
