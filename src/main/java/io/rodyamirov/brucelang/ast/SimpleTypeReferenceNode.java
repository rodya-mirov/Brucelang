package io.rodyamirov.brucelang.ast;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public final class SimpleTypeReferenceNode extends TypeReferenceNode {

    private String name;

    public SimpleTypeReferenceNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitSimpleTypeReference(this);
    }

    @Override
    public <T> T acceptTR(TypeReferenceNodeVisitor<T> visitor) {
        return visitor.visitSimpleTypeRef(this);
    }

    @Override
    public List<? extends ASTNode> getChildren() {
        return Collections.emptyList();
    }

    public TypeDeclarationNode getDeclaration() {
        return getNamespace().getTypeDeclaration(name);
    }

    @Override
    public boolean sameType(@Nonnull TypeReferenceNode other) {
        if (!(other instanceof SimpleTypeReferenceNode)) {
            return false;
        }

        // reference equality is intentional
        return this.getDeclaration() == ((SimpleTypeReferenceNode) other).getDeclaration();
    }
}
