package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BinOpExprNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionDeclarationNode;
import io.rodyamirov.brucelang.ast.FunctionDefinitionNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.ParameterNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.util.ProgrammerError;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;

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
    public static Namespace makeNamespace(ProgramNode programNode) {
        new RegistrarVisitor().visitProgram(programNode);

        return programNode.getNamespace();
    }

    private static class RegistrarVisitor implements ASTNode.ASTVisitor {
        private final Stack<Namespace> namespaceStack = new ArrayStack<>();

        @Override
        public void visitProgram(ProgramNode programNode) {
            namespaceStack.clear();

            Namespace root = new Namespace("global");
            programNode.setNamespace(root);

            namespaceStack.push(root);

            programNode.getStatements()
                    .forEach(node -> node.accept(this));

            namespaceStack.pop();

            if (namespaceStack.size() > 0) {
                throw new ProgrammerError("Something wasn't popping its stack properly!");
            }
        }

        @Override
        public void visitFunctionDefinition(FunctionDefinitionNode functionDefinitionNode) {
            Namespace localSpace = namespaceStack.peek();
            functionDefinitionNode.setNamespace(localSpace);

            functionDefinitionNode.getFunctionDeclarationNode().accept(this);

            String functionName = functionDefinitionNode
                    .getFunctionDeclarationNode().getFunctionName();

            // AST hierarchy doesn't completely line up with name resolution -- the definition of the
            // function is in the associated space, but it's a sibling, rather than a child, of the
            // declaration. This is so that we don't have diamond inheritance --
            // DeclarationNode and StatementNode are incompatible
            Namespace functionSpace = localSpace.getChild(functionName);

            namespaceStack.push(functionSpace);

            functionDefinitionNode.getDefinitionStatement().accept(this);

            namespaceStack.pop();
        }

        @Override
        public void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
            Namespace localSpace = namespaceStack.peek();
            functionDeclarationNode.setNamespace(localSpace);

            String name = functionDeclarationNode.getFunctionName();

            localSpace.register(name, functionDeclarationNode);

            namespaceStack.push(localSpace.makeNamedChild(name));

            functionDeclarationNode.getParameters().forEach(node -> node.accept(this));

            namespaceStack.pop();
        }

        @Override
        public void visitParameterNode(ParameterNode parameterNode) {
            Namespace localSpace = namespaceStack.peek();
            parameterNode.setNamespace(localSpace);

            localSpace.register(parameterNode.getParameterName(), parameterNode);
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            Namespace localSpace = namespaceStack.peek();
            variableDefinitionNode.setNamespace(localSpace);

            variableDefinitionNode.getVariableDeclarationNode().accept(this);
            variableDefinitionNode.getEvalExpr().accept(this);
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            Namespace localSpace = namespaceStack.peek();
            variableDeclarationNode.setNamespace(localSpace);

            localSpace.register(variableDeclarationNode.getVarName(), variableDeclarationNode);
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            Namespace localSpace = namespaceStack.peek();
            blockStatementNode.setNamespace(localSpace);

            namespaceStack.push(localSpace.makeBlockChild());

            blockStatementNode.getStatements().forEach(node -> node.accept(this));

            namespaceStack.pop();
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            Namespace localSpace = namespaceStack.peek();
            doStatementNode.setNamespace(localSpace);

            doStatementNode.getEvalExpression().accept(this);
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            Namespace localSpace = namespaceStack.peek();
            returnStatementNode.setNamespace(localSpace);

            returnStatementNode.getEvalExpression().accept(this);
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            Namespace localSpace = namespaceStack.peek();
            ifStatementNode.setNamespace(localSpace);

            ifStatementNode.getConditions().forEach(node -> node.accept(this));
            ifStatementNode.getResultingStatements().forEach(node -> node.accept(this));

            StatementNode elseStatement = ifStatementNode.getElseStatement();
            if (elseStatement != null) {
                elseStatement.accept(this);
            }
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            Namespace localSpace = namespaceStack.peek();
            functionCallNode.setNamespace(localSpace);

            functionCallNode.getArguments().forEach(node -> node.accept(this));
        }

        @Override
        public void visitBinOpExprNode(BinOpExprNode binOpExprNode) {
            Namespace localSpace = namespaceStack.peek();
            binOpExprNode.setNamespace(localSpace);

            binOpExprNode.getLeftChild().accept(this);
            binOpExprNode.getRightChild().accept(this);
        }

        @Override
        public void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode) {
            Namespace localSpace = namespaceStack.peek();
            unaryOpExprNode.setNamespace(localSpace);

            unaryOpExprNode.getChild().accept(this);
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            Namespace localSpace = namespaceStack.peek();
            integerNode.setNamespace(localSpace);

            // no children
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            Namespace localSpace = namespaceStack.peek();
            booleanNode.setNamespace(localSpace);

            // no children
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            Namespace localSpace = namespaceStack.peek();
            stringExprNode.setNamespace(localSpace);

            // no children
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            Namespace localSpace = namespaceStack.peek();
            variableReferenceNode.setNamespace(localSpace);
        }
    }
}