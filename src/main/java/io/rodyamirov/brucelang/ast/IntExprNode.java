package io.rodyamirov.brucelang.ast;

import java.util.Collections;
import java.util.List;

public final class IntExprNode extends ExpressionNode {
    private final Integer value;

    public IntExprNode(Integer value) {
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitIntExprNode(this);
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public List<ASTNode> getExtendedChildren() {
        return Collections.emptyList();
    }
}
