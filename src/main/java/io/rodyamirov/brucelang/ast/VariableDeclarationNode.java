package io.rodyamirov.brucelang.ast;

import java.util.Collections;
import java.util.List;

public final class VariableDeclarationNode extends ASTNode implements Typed {
        private final String varName;
    private TypeReferenceNode typeReference;

    public VariableDeclarationNode(String varName, TypeReferenceNode typeReference) {
        this.varName = varName;
        this.typeReference = typeReference;
    }

    public String getVarName() {
        return varName;
    }

    public TypeReferenceNode getType() {
        return typeReference;
    }

    @Override
    public void setType(TypeReferenceNode type) {
        this.typeReference = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitVariableDeclaration(this);
    }

    public String getCanonicalName() {
        return getNamespace().getFullName() + "." + getVarName();
    }

    @Override
    public List<ASTNode> getChildren() {
        return Collections.singletonList(typeReference);
    }
}
