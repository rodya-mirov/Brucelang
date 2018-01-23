package io.rodyamirov.brucelang.ast;

public final class DoStatementNode extends StatementNode {
    private final ExpressionNode evalExpression;

    public DoStatementNode(ExpressionNode evalExpression) {
        this.evalExpression = evalExpression;

        evalExpression.setParent(this);
    }

    public ExpressionNode getEvalExpression() {
        return evalExpression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitDoStatement(this);
    }
}
