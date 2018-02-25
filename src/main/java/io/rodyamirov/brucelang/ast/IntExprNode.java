package io.rodyamirov.brucelang.ast;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public final class IntExprNode extends ExpressionNode {
    private final BigInteger value;

    public IntExprNode(BigInteger value) {
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitIntExprNode(this);
    }

    public BigInteger getValue() {
        return value;
    }

    @Override
    public List<ASTNode> getExtendedChildren() {
        return Collections.emptyList();
    }
}
