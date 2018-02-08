package io.rodyamirov.brucelang.ast;

public final class ReturnStatementNode extends StatementNode {
    private ExpressionNode evalExpression;

    public ReturnStatementNode(ExpressionNode evalExpression) {
        this.evalExpression = evalExpression;
    }

    public ExpressionNode getEvalExpression() {
        return evalExpression;
    }

    public void setEvalExpression(ExpressionNode evalExpression) {
        this.evalExpression = evalExpression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitReturnStatement(this);
    }
}
