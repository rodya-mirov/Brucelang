package io.rodyamirov.brucelang.ast;

import static io.rodyamirov.brucelang.types.UnknownType.UNKNOWN_TYPE;

/**
 * Just an extension class signaling "this is a thing that can be evaluated"
 */
public abstract class ExpressionNode extends TypedNode {
    protected ExpressionNode() {
        super(UNKNOWN_TYPE);
    }

    /**
     * Gives a canonical name in the form of [namespaceName].$[myId]
     *
     * This can be overridden in the case of an expression whose name we definitely know
     * @return
     */
    public String getCanonicalName() {
        throw new RuntimeException("General expressions don't have names!");
    }
}
