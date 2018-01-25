package io.rodyamirov.brucelang.ast;

public final class VariableDefinitionNode extends StatementNode {
    private final VariableDeclarationNode variableDeclarationNode;
    private final ExpressionNode evalExpr;

    public VariableDefinitionNode(String varName, ExpressionNode evalExpr) {
        this.variableDeclarationNode = new VariableDeclarationNode(varName);
        this.evalExpr = evalExpr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitVariableDefinition(this);
    }

    public VariableDeclarationNode getVariableDeclarationNode() {
        return variableDeclarationNode;
    }

    public ExpressionNode getEvalExpr() {
        return evalExpr;
    }
}
