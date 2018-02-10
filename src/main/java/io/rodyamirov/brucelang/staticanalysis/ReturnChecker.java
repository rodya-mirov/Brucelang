package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.ASTNode;
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
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;
import io.rodyamirov.brucelang.util.collections.StackHelper;

import java.util.concurrent.atomic.AtomicBoolean;

public class ReturnChecker {
    private ReturnChecker() {
    }

    public static void checkFunctionsReturn(ProgramNode programNode) {
        new ReturnVisitor().visitProgram(programNode);
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

    private static class ReturnVisitor implements ASTNode.ASTVisitor {
        private Stack<FunctionExprNode> functionStack = new ArrayStack<>();
        private StackHelper<FunctionExprNode> fnStackHelper = new StackHelper<>(functionStack);

        private Stack<AtomicBoolean> returnCatchers = new ArrayStack<>();
        private StackHelper<AtomicBoolean> catcherhelper = new StackHelper<>(returnCatchers);

        @Override
        public void visitProgram(ProgramNode programNode) {
            programNode.getStatements().forEach(statementNode -> statementNode.accept(this));
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionDefinitionNode) {
            AtomicBoolean didReturn = new AtomicBoolean(false);

            functionDefinitionNode.getParameterNodes().forEach(node -> node.accept(this));

            catcherhelper.safePushPop(
                    didReturn,
                    () -> fnStackHelper.safePushPop(
                            functionDefinitionNode,
                            () -> functionDefinitionNode.getDefinitionStatements()
                                    .forEach(statementNode -> statementNode.accept(this))
                    )
            );

            if (!didReturn.get()) {
                throw new NoReturnException(functionDefinitionNode);
            }
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            if (returnCatchers.size() > 0 && returnCatchers.peek().get()) {
                throw new UnreachableCodeException(variableDefinitionNode);
            }

            variableDefinitionNode.getVariableDeclarationNode().accept(this);
            variableDefinitionNode.getEvalExpr().accept(this);
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            // no op, terminal node
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            if (returnCatchers.size() > 0 && returnCatchers.peek().get()) {
                throw new UnreachableCodeException(blockStatementNode);
            }

            blockStatementNode.getStatements().forEach(stmt -> stmt.accept(this));
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            if (returnCatchers.size() > 0 && returnCatchers.peek().get()) {
                throw new UnreachableCodeException(doStatementNode);
            }

            doStatementNode.getEvalExpression().accept(this);
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            if (functionStack.size() == 0) {
                throw new ReturnNotInFunctionException(returnStatementNode);
            }

            if (returnCatchers.size() > 0 && returnCatchers.peek().get()) {
                throw new UnreachableCodeException(returnStatementNode);
            }

            returnCatchers.peek().set(true);
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            if (returnCatchers.size() > 0 && returnCatchers.peek().get()) {
                throw new UnreachableCodeException(ifStatementNode);
            }

            // basically have to check if EVERY result block returns a value
            boolean allReturned = true;

            for (StatementNode thenStmt : ifStatementNode.getResultingStatements()) {
                AtomicBoolean thisReturns = new AtomicBoolean(false);
                catcherhelper.safePushPop(
                        thisReturns,
                        () -> thenStmt.accept(this)
                );
                allReturned &= thisReturns.get();
            }

            if (ifStatementNode.getElseStatement() != null) {
                AtomicBoolean elseReturns = new AtomicBoolean(false);
                catcherhelper.safePushPop(
                        elseReturns,
                        () -> ifStatementNode.getElseStatement().accept(this)
                );
                allReturned &= elseReturns.get();
            } else {
                allReturned = false;
            }

            if (returnCatchers.size() > 0 && allReturned) {
                returnCatchers.peek().set(true);
            }
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            functionCallNode.getFunctionNode().accept(this);
            functionCallNode.getArguments().forEach(expr -> expr.accept(this));
        }

        @Override
        public void visitBinOpExprNode(BinOpExprNode binOpExprNode) {
            binOpExprNode.getLeftChild().accept(this);
            binOpExprNode.getRightChild().accept(this);
        }

        @Override
        public void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode) {
            unaryOpExprNode.getChild().accept(this);
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            // no op, terminal node
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            // no op, terminal node
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            // no op, terminal node
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            // no op, terminal node
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            // no op, terminal node
        }
    }
}
