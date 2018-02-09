package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.types.TypeDeclaration;

/**
 * Just an extension class signaling "this is a thing that can be evaluated"
 */
public abstract class ExpressionNode extends ASTNode implements Typed {
    // whether this expression is a definitional expression (something is "let x = [this expression]")
    private boolean isDefExpr;
    private VariableDeclarationNode definedName;
    private TypeDeclaration typeDeclaration;

    protected ExpressionNode() {
        isDefExpr = false;
        definedName = null;
        typeDeclaration = null;
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

    @Override
    public TypeDeclaration getType() {
        return typeDeclaration;
    }

    @Override
    public void setType(TypeDeclaration type) {
        this.typeDeclaration = type;
    }
}
