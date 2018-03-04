package io.rodyamirov.brucelang.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Just an extension class signaling "this is a thing that can be evaluated"
 */
public abstract class ExpressionNode extends ASTNode implements Typed {
    // whether this expression is a definitional expression (something is "let x = [this expression]")
    private boolean isDefExpr;
    private VariableDeclarationNode definedName; // a reference to the definition, if any; this is not a child!
    private TypeReferenceNode typeReference;

    protected ExpressionNode() {
        isDefExpr = false;
        definedName = null;
        typeReference = null;
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
    public final List<? extends ASTNode> getChildren() {
        List<ASTNode> out = new ArrayList<>();
        if (typeReference != null) {
            out.add(typeReference);
        }
        // NB: not including defined name because it's not a "child"
        out.addAll(getExtendedChildren());
        return out;
    }

    protected abstract List<? extends ASTNode> getExtendedChildren();

    @Override
    public TypeReferenceNode getType() {
        return typeReference;
    }

    @Override
    public void setType(TypeReferenceNode type) {
        this.typeReference = type;
    }
}
