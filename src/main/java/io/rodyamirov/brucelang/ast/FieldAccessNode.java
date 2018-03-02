package io.rodyamirov.brucelang.ast;

import java.util.Collections;
import java.util.List;

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

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFieldAccess(this);
    }

    @Override
    public List<ExpressionNode> getExtendedChildren() {
        return Collections.singletonList(baseNode);
    }
}
