package io.rodyamirov.brucelang.ast;

import java.util.ArrayList;
import java.util.List;

public class TypeFuncCallNode extends ExpressionNode {
    private ExpressionNode baseNode;
    private List<TypeReferenceNode> typeArguments;

    public TypeFuncCallNode(ExpressionNode baseNode,
            List<TypeReferenceNode> typeArguments) {
        this.baseNode = baseNode;
        this.typeArguments = typeArguments;
    }

    public ExpressionNode getBaseNode() {
        return baseNode;
    }

    public List<TypeReferenceNode> getTypeArguments() {
        return typeArguments;
    }

    @Override
    protected List<? extends ASTNode> getExtendedChildren() {
        List<ASTNode> extendedChildren = new ArrayList<>(typeArguments.size() + 1);
        extendedChildren.add(baseNode);
        extendedChildren.addAll(typeArguments);
        return extendedChildren;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitTypeFuncCall(this);
    }
}
