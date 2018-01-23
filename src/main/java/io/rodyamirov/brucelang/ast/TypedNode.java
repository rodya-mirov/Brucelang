package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.types.Type;

/**
 * Intermediate class for ASTNodes which make sense to have associated types.
 */
public abstract class TypedNode<T extends ASTNode> extends ASTNode<T> {
    private Type nodeType;

    protected TypedNode(Type defaultType) {
        setType(defaultType);
    }

    public Type getType() {
        return nodeType;
    }

    public void setType(Type nodeType) {
        this.nodeType = nodeType;
    }
}
