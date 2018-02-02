package io.rodyamirov.brucelang.ast;

public final class BoolExprNode extends ExpressionNode {
    private final boolean value;

    public BoolExprNode(boolean value) {
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitBoolExprNode(this);
    }

    public boolean getValue() {
        return value;
    }
}
