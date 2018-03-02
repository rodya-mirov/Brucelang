package io.rodyamirov.brucelang.ast;

import java.util.Collections;
import java.util.List;

public class FieldDeclarationNode extends StatementNode {
    private String name;
    private TypeReferenceNode type;

    public FieldDeclarationNode(String name, TypeReferenceNode type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public TypeReferenceNode getType() {
        return type;
    }

    public String getCanonicalName() {
        return getNamespace().getFullName() + "." + this.name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFieldDeclaration(this);
    }

    @Override
    public List<? extends ASTNode> getChildren() {
        return Collections.singletonList(type);
    }
}
