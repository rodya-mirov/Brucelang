package io.rodyamirov.brucelang.staticanalysis;

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
import io.rodyamirov.brucelang.ast.StatementListHolder;
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;
import io.rodyamirov.brucelang.util.collections.StackHelper;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A desugarer class which replaces anonymous functions (that is, lambdas which are defined but not
 * assigned to a variable) with named functions (so every functions is introduced in the form
 * `let f = args => {stmts}`)
 */
public class LambdaDesugarer {
    private LambdaDesugarer() {
    }

    public static void removeAnonymousFunctions(ProgramNode programNode) {
        new LambdaDesugarerVisitor().visitProgram(programNode);
    }

    private interface NodeReplacer {
        void replaceNode(ASTNode toReplace);
    }

    private static class LambdaDesugarerVisitor implements ASTNode.ASTVisitor {
        private final Stack<StatementListHolder> stmtListHolders = new ArrayStack<>();

        private final Stack<NodeReplacer> nodeReplacers = new ArrayStack<>();
        private final StackHelper<NodeReplacer> replacerHelper = new StackHelper<>(nodeReplacers);

        // This is the current index of the current stmtListHolder to insert a new statement at
        private Stack<AtomicInteger> insertionPoints = new ArrayStack<>();

        @Override
        public void visitProgram(ProgramNode programNode) {
            stmtListHolders.push(programNode);

            AtomicInteger stmtIndex = new AtomicInteger(0);
            insertionPoints.push(stmtIndex);
            while (stmtIndex.get() < programNode.getStatements().size()) {
                replacerHelper.safePushPop(
                        node -> {
                            int insertAt = stmtIndex.getAndIncrement();
                            programNode.insertStatementNode(insertAt, (StatementNode) node);
                        },
                        () -> programNode.getStatements().get(stmtIndex.get()).accept(this)
                );
                stmtIndex.incrementAndGet();
            }

            insertionPoints.pop();
            stmtListHolders.pop();
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionDefinitionNode) {
            // basic visitor stuff -- this defines a block and we need to visit inside it
            stmtListHolders.push(functionDefinitionNode);

            AtomicInteger counter = new AtomicInteger(0);
            for (VariableDeclarationNode param : functionDefinitionNode.getParameterNodes()) {
                replacerHelper.safePushPop(
                        node -> functionDefinitionNode.getParameterNodes().set(counter.get(), (VariableDeclarationNode) node),
                        () -> param.accept(this)
                );
                counter.incrementAndGet();
            }

            AtomicInteger stmtIndex = new AtomicInteger(0);
            insertionPoints.push(stmtIndex);
            while (stmtIndex.get() < functionDefinitionNode.getDefinitionStatements().size()) {
                replacerHelper.safePushPop(
                        node -> {
                            int insertAt = stmtIndex.getAndIncrement();
                            functionDefinitionNode.insertStatementNode(insertAt, (StatementNode) node);
                        },
                        () -> functionDefinitionNode.getDefinitionStatements().get(stmtIndex.get()).accept(this)
                );
                stmtIndex.incrementAndGet();
            }

            insertionPoints.pop();
            stmtListHolders.pop();

            // but we may also need to replace this expression!
            if (!functionDefinitionNode.isDefExpr()) {
                // then this is anonymous, so make a new node, and insert it at the above block
                String anonName = FunctionExprNode.makeAnonName();
                VariableDeclarationNode declaration = new VariableDeclarationNode(anonName);
                functionDefinitionNode.assignToName(declaration);

                stmtListHolders.peek().insertStatementNode(
                        insertionPoints.peek().get(),
                        new VariableDefinitionNode(declaration, functionDefinitionNode)
                );

                nodeReplacers.peek().replaceNode(
                        new VariableReferenceNode(anonName)
                );
            }
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            replacerHelper.safePushPop(
                    node -> variableDefinitionNode.setVariableDeclarationNode((VariableDeclarationNode) node),
                    () -> variableDefinitionNode.getVariableDeclarationNode().accept(this)
            );

            variableDefinitionNode.getEvalExpr()
                    .assignToName(variableDefinitionNode.getVariableDeclarationNode());

            replacerHelper.safePushPop(
                    node -> variableDefinitionNode.setEvalExpr((ExpressionNode) node),
                    () -> variableDefinitionNode.getEvalExpr().accept(this)
            );
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            // do nothing! This node is terminal and doesn't need to be desugared
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            stmtListHolders.push(blockStatementNode);

            AtomicInteger stmtIndex = new AtomicInteger(0);
            insertionPoints.push(stmtIndex);
            while (stmtIndex.get() < blockStatementNode.getStatements().size()) {
                replacerHelper.safePushPop(
                        node -> {
                            int insertAt = stmtIndex.getAndIncrement();
                            blockStatementNode.insertStatementNode(insertAt, (StatementNode) node);
                        },
                        () -> blockStatementNode.getStatements().get(stmtIndex.get()).accept(this)
                );
                stmtIndex.incrementAndGet();
            }

            insertionPoints.pop();
            stmtListHolders.pop();
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            replacerHelper.safePushPop(
                    node -> doStatementNode.setEvalExpression((ExpressionNode) node),
                    () -> doStatementNode.getEvalExpression().accept(this)
            );
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            replacerHelper.safePushPop(
                    node -> returnStatementNode.setEvalExpression((ExpressionNode) node),
                    () -> returnStatementNode.getEvalExpression().accept(this)
            );
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            AtomicInteger counter = new AtomicInteger(0);
            for (int i = 0; i < ifStatementNode.getConditions().size(); i++) {
                replacerHelper.safePushPop(
                        node -> ifStatementNode.getConditions().set(counter.get(), (ExpressionNode) node),
                        () -> ifStatementNode.getConditions().get(counter.get()).accept(this)
                );

                replacerHelper.safePushPop(
                        node -> ifStatementNode.getResultingStatements().set(counter.get(), (BlockStatementNode) node),
                        () -> ifStatementNode.getResultingStatements().get(counter.get()).accept(this)
                );

                counter.incrementAndGet();
            }

            if (ifStatementNode.getElseStatement() != null) {
                replacerHelper.safePushPop(
                        node -> ifStatementNode.setElseStatement((BlockStatementNode) node),
                        () -> ifStatementNode.getElseStatement().accept(this)
                );
            }
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            replacerHelper.safePushPop(
                    node -> functionCallNode.setFunctionNode((ExpressionNode) node),
                    () -> functionCallNode.getFunctionNode().accept(this)
            );

            AtomicInteger counter = new AtomicInteger(0);
            for (ExpressionNode arg : functionCallNode.getArguments()) {
                replacerHelper.safePushPop(
                        node -> functionCallNode.getArguments().set(counter.get(), (ExpressionNode) node),
                        () -> arg.accept(this)
                );

                counter.incrementAndGet();
            }
        }

        @Override
        public void visitBinOpExprNode(BinOpExprNode binOpExprNode) {
            replacerHelper.safePushPop(
                    node -> binOpExprNode.setLeftChild((ExpressionNode) node),
                    () -> binOpExprNode.getLeftChild().accept(this)
            );

            replacerHelper.safePushPop(
                    node -> binOpExprNode.setRightChild((ExpressionNode) node),
                    () -> binOpExprNode.getRightChild().accept(this)
            );
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            replacerHelper.safePushPop(
                    node -> fieldAccessNode.setBaseNode((ExpressionNode) node),
                    () -> fieldAccessNode.getBaseNode().accept(this)
            );
        }

        @Override
        public void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode) {
            replacerHelper.safePushPop(
                    node -> unaryOpExprNode.setChild((ExpressionNode) node),
                    () -> unaryOpExprNode.getChild().accept(this)
            );
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            // do nothing! This node is terminal and doesn't need to be desugared
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            // do nothing! This node is terminal and doesn't need to be desugared
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            // do nothing! This node is terminal and doesn't need to be desugared
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            // do nothing! This node is terminal and doesn't need to be desugared
        }
    }
}
