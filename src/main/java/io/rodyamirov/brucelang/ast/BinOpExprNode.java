package io.rodyamirov.brucelang.ast;

import java.util.ArrayList;
import java.util.List;

// TODO -- remove this class and replace it with a function call node
public final class BinOpExprNode extends ExpressionNode {
    private final Operators.BinOp operation;
    private ExpressionNode leftChild, rightChild;

    public BinOpExprNode(Operators.BinOp operation, ExpressionNode leftChild, ExpressionNode rightChild) {
        this.operation = operation;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitBinOpExprNode(this);
    }

    public Operators.BinOp getOperation() {
        return operation;
    }

    public ExpressionNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(ExpressionNode leftChild) {
        this.leftChild = leftChild;
    }

    public ExpressionNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(ExpressionNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public List<ExpressionNode> getChildren() {
        List<ExpressionNode> out = new ArrayList<>(2);

        out.add(leftChild);
        out.add(rightChild);

        return out;
    }
}
