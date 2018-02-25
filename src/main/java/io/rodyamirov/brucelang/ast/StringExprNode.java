package io.rodyamirov.brucelang.ast;

import java.util.Collections;
import java.util.List;

public final class StringExprNode extends ExpressionNode {
    private final String value;

    public StringExprNode(String value) {
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitStringExprNode(this);
    }

    public String getValue() {
        return value;
    }

    @Override
    public List<ASTNode> getExtendedChildren() {
        return Collections.emptyList();
    }
}
