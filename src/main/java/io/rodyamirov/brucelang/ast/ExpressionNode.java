package io.rodyamirov.brucelang.ast;

import static io.rodyamirov.brucelang.types.UnknownType.UNKNOWN_TYPE;

/**
 * Just an extension class signaling "this is a thing that can be evaluated"
 */
public abstract class ExpressionNode extends TypedNode {
    // whether this expression is a definitional expression (something is "let x = [this expression]")
    private boolean isDefExpr;
    private VariableDeclarationNode definedName;

    protected ExpressionNode() {
        super(UNKNOWN_TYPE);
        isDefExpr = false;
        definedName = null;
    }

    public boolean isDefExpr() {
        return isDefExpr;
    }

    public VariableDeclarationNode getDefinedName() {
        return definedName;
    }

    public void assignToName(VariableDeclarationNode definedName) {
        this.isDefExpr = true;
        this.definedName = definedName;
    }
}
