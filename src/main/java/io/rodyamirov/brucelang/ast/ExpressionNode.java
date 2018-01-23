package io.rodyamirov.brucelang.ast;

import static io.rodyamirov.brucelang.types.UnknownType.UNKNOWN_TYPE;

/**
 * Just an extension class signaling "this is a thing that can be evaluated"
 */
public abstract class ExpressionNode extends TypedNode<ASTNode> {
    protected ExpressionNode() {
        super(UNKNOWN_TYPE);
    }
}
