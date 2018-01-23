package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.astexceptions.WrongOrderException;
import io.rodyamirov.brucelang.staticanalysis.Namespace;

import javax.annotation.Nonnull;

public abstract class ASTNode<ParentType extends ASTNode> {
    private Namespace namespace;
    private ParentType parent;

    protected ASTNode() {
    }

    public abstract void accept(ASTVisitor visitor);

    public void setNamespace(@Nonnull Namespace namespace) {
        this.namespace = namespace;
    }

    public ParentType getParent() {
        return parent;
    }

    public void setParent(ParentType parent) {
        this.parent = parent;
    }

    @Nonnull
    public Namespace getNamespace() {
        if (namespace == null) {
            throw new WrongOrderException(this, "Namespace accessed before assignment!");
        }

        return namespace;
    }

    public interface ASTVisitor {
        void visitProgram(ProgramNode programNode);

        void visitFunctionDefinition(FunctionDefinitionNode functionDefinitionNode);
        void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode);

        void visitParameterNode(ParameterNode parameterNode);
        void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode);
        void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode);

        void visitBlockStatement(BlockStatementNode blockStatementNode);
        void visitDoStatement(DoStatementNode doStatementNode);
        void visitReturnStatement(ReturnStatementNode returnStatementNode);
        void visitIfStatement(IfStatementNode ifStatementNode);

        void visitFunctionCallNode(FunctionCallNode functionCallNode);
        void visitBinOpExprNode(BinOpExprNode binOpExprNode);
        void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode);

        void visitIntExprNode(IntExprNode integerNode);
        void visitBoolExprNode(BoolExprNode booleanNode);
        void visitStringExprNode(StringExprNode stringExprNode);
        void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode);
    }
}
