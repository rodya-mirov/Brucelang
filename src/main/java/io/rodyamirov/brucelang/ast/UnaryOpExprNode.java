package io.rodyamirov.brucelang.ast;

// TODO -- remove this class and replace it with a function call node
public final class UnaryOpExprNode extends ExpressionNode {
    private final Operators.UnOp operation;
    private final ExpressionNode child;

    public UnaryOpExprNode(Operators.UnOp operation, ExpressionNode child) {
        this.operation = operation;
        this.child = child;

        this.child.setParent(this);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitUnaryOpExprNode(this);
    }

    public Operators.UnOp getOperation() {
        return operation;
    }

    public ExpressionNode getChild() {
        return child;
    }
}
