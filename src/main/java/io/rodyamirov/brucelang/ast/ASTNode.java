package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.astexceptions.WrongOrderException;
import io.rodyamirov.brucelang.staticanalysis.Namespace;

import javax.annotation.Nonnull;

public abstract class ASTNode {
    private Namespace namespace;

    protected ASTNode() {
    }

    public abstract void accept(ASTVisitor visitor);

    public void setNamespace(@Nonnull Namespace namespace) {
        this.namespace = namespace;
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

        void visitFunctionExpr(FunctionExprNode functionDefinitionNode);
        void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode);

        void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode);

        void visitBlockStatement(BlockStatementNode blockStatementNode);
        void visitDoStatement(DoStatementNode doStatementNode);
        void visitReturnStatement(ReturnStatementNode returnStatementNode);
        void visitIfStatement(IfStatementNode ifStatementNode);

        void visitFunctionCallNode(FunctionCallNode functionCallNode);
        void visitBinOpExprNode(BinOpExprNode binOpExprNode);
        void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode);

        void visitFieldAccess(FieldAccessNode fieldAccessNode);

        void visitIntExprNode(IntExprNode integerNode);
        void visitBoolExprNode(BoolExprNode booleanNode);
        void visitStringExprNode(StringExprNode stringExprNode);
        void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode);
    }
}
