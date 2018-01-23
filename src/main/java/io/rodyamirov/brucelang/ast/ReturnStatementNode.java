package io.rodyamirov.brucelang.ast;

public final class ReturnStatementNode extends StatementNode {
    private final ExpressionNode evalExpression;

    public ReturnStatementNode(ExpressionNode evalExpression) {
        this.evalExpression = evalExpression;

        this.evalExpression.setParent(this);
    }

    public ExpressionNode getEvalExpression() {
        return evalExpression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitReturnStatement(this);
    }
}
