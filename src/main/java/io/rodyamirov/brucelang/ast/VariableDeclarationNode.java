package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.types.TypeDeclaration;

import javax.annotation.Nonnull;

public final class VariableDeclarationNode extends ASTNode implements Typed {
        private final String varName;
    private TypeDeclaration typeDeclaration;

    public VariableDeclarationNode(String varName, @Nonnull TypeDeclaration typeDeclaration) {
        this.varName = varName;
        this.typeDeclaration = typeDeclaration;
    }

    public String getVarName() {
        return varName;
    }

    public TypeDeclaration getType() {
        return typeDeclaration;
    }

    @Override
    public void setType(TypeDeclaration type) {
        this.typeDeclaration = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitVariableDeclaration(this);
    }

    public String getCanonicalName() {
        return getNamespace().getFullName() + "." + getVarName();
    }
}
