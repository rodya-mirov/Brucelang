package io.rodyamirov.brucelang.ast;

public final class VariableDefinitionNode extends StatementNode {
    private VariableDeclarationNode variableDeclarationNode;
    private ExpressionNode evalExpr;

    public VariableDefinitionNode(VariableDeclarationNode varDecl, ExpressionNode evalExpr) {
        this.variableDeclarationNode = varDecl;
        this.evalExpr = evalExpr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitVariableDefinition(this);
    }

    public VariableDeclarationNode getVariableDeclarationNode() {
        return variableDeclarationNode;
    }

    public void setVariableDeclarationNode(
            VariableDeclarationNode variableDeclarationNode) {
        this.variableDeclarationNode = variableDeclarationNode;
    }

    public ExpressionNode getEvalExpr() {
        return evalExpr;
    }

    public void setEvalExpr(ExpressionNode evalExpr) {
        this.evalExpr = evalExpr;
    }
}
