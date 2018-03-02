package io.rodyamirov.brucelang.ast;

import java.util.Collections;
import java.util.List;

public class TypeDeclarationNode extends ASTNode {
    private String name;

    public TypeDeclarationNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCanonicalName() {
        return this.getNamespace() + "." + this.name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitTypeDeclaration(this);
    }

    @Override
    public List<? extends ASTNode> getChildren() {
        return Collections.emptyList();
    }
}
