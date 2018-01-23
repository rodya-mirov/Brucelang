package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.types.Type;

/**
 * Marker interface for nodes which indicate that this node is a definition (and should be referred
 * to accordingly).
 */
public abstract class DeclarationNode<T extends ASTNode> extends TypedNode<T> {
    protected DeclarationNode(Type defaultType) {
        super(defaultType);
    }
}
