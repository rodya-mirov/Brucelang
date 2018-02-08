package io.rodyamirov.brucelang.ast;

public class FieldAccessNode extends ExpressionNode {
    private ExpressionNode baseNode;
    private final String fieldName;

    public FieldAccessNode(ExpressionNode baseNode, String fieldName) {
        this.baseNode = baseNode;
        this.fieldName = fieldName;
    }

    public ExpressionNode getBaseNode() {
        return baseNode;
    }

    public void setBaseNode(ExpressionNode baseNode) {
        this.baseNode = baseNode;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFieldAccess(this);
    }
}