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
import io.rodyamirov.brucelang.ast.StatementListHolder;
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.util.ProgrammerError;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.LinkedQueue;
import io.rodyamirov.brucelang.util.collections.Queue;
import io.rodyamirov.brucelang.util.collections.Stack;
import io.rodyamirov.brucelang.util.collections.StackHelper;

/**
 * Visitor which associates references (to functions and variables) with the declarations
 * (of functions, local variables, and parameters). Name resolution logic is contained in this class
 * and not used externally.
 */
public final class NameRegistrar {
    private NameRegistrar() {
    }

    /**
     * This does complete name resolution for the entire program tree, then returns the namespace
     * associated with the program.
     *
     * @param programNode Root node of the program, to be used for name resolution.
     * @return
     */
    public static void registerNames(ProgramNode programNode) {
        Namespace root = new Namespace("global");
        Queue<Visitable> toProcess = new LinkedQueue<>();
        toProcess.enqueue(new Visitable(programNode, root));

        while (toProcess.size() > 0) {
            Visitable toVisit = toProcess.dequeue();

            toVisit.nodeToVisit.accept(new RegistrarVisitor(toProcess, toVisit.context));
        }
    }

    private static class Visitable {
        final ASTNode nodeToVisit;
        final Namespace context;

        public Visitable(ASTNode nodeToVisit, Namespace context) {
            this.nodeToVisit = nodeToVisit;
            this.context = context;
        }
    }

    private static class RegistrarVisitor implements ASTNode.ASTVisitor {
        private final Queue<Visitable> toProcess;
        private final Namespace currentContext;

        public RegistrarVisitor(Queue<Visitable> toProcess, Namespace currentContext) {
            this.toProcess = toProcess;
            this.currentContext = currentContext;
        }

        @Override
        public void visitProgram(ProgramNode programNode) {
            programNode.setNamespace(currentContext);

            programNode.getStatements()
                    .forEach(node -> node.accept(this));
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionDefinitionNode) {
            functionDefinitionNode.setNamespace(currentContext);

            Namespace functionSpace = currentContext.makeFunctionChild(functionDefinitionNode);

            for (VariableDeclarationNode vdn : functionDefinitionNode.getParameterNodes()) {
                toProcess.enqueue(new Visitable(vdn, functionSpace));
            }

            for (StatementNode stmt : functionDefinitionNode.getDefinitionStatements()) {
                toProcess.enqueue(new Visitable(stmt, functionSpace));
            }
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            variableDefinitionNode.setNamespace(currentContext);

            variableDefinitionNode.getVariableDeclarationNode().accept(this);
            variableDefinitionNode.getEvalExpr().accept(this);
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            variableDeclarationNode.setNamespace(currentContext);

            currentContext.register(variableDeclarationNode.getVarName(), variableDeclarationNode);
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            blockStatementNode.setNamespace(currentContext);

            Namespace blockSpace = currentContext.makeBlockChild();

            for (StatementNode stmt : blockStatementNode.getStatements()) {
                toProcess.enqueue(new Visitable(stmt, blockSpace));
            }
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            doStatementNode.setNamespace(currentContext);

            doStatementNode.getEvalExpression().accept(this);
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            returnStatementNode.setNamespace(currentContext);

            returnStatementNode.getEvalExpression().accept(this);
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            ifStatementNode.setNamespace(currentContext);

            ifStatementNode.getConditions().forEach(node -> node.accept(this));
            ifStatementNode.getResultingStatements().forEach(node -> node.accept(this));

            StatementNode elseStatement = ifStatementNode.getElseStatement();
            if (elseStatement != null) {
                elseStatement.accept(this);
            }
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            functionCallNode.setNamespace(currentContext);

            functionCallNode.getFunctionNode().accept(this);
            functionCallNode.getArguments().forEach(node -> node.accept(this));
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            fieldAccessNode.setNamespace(currentContext);

            fieldAccessNode.getBaseNode().accept(this);
            // NB: we're not registering that this thing has a field, here; it's not a unique name
            // and it doesn't go in the namespace
        }

        @Override
        public void visitBinOpExprNode(BinOpExprNode binOpExprNode) {
            binOpExprNode.setNamespace(currentContext);

            binOpExprNode.getLeftChild().accept(this);
            binOpExprNode.getRightChild().accept(this);
        }

        @Override
        public void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode) {
            unaryOpExprNode.setNamespace(currentContext);

            unaryOpExprNode.getChild().accept(this);
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            integerNode.setNamespace(currentContext);

            // no children
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            booleanNode.setNamespace(currentContext);

            // no children
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            stringExprNode.setNamespace(currentContext);

            // no children
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            variableReferenceNode.setNamespace(currentContext);

            // no children
        }
    }
}
