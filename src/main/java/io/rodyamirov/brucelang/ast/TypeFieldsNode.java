package io.rodyamirov.brucelang.ast;

import java.util.List;

// just the spec of a type, but this creates a new namespace for its children, which is why we need it
public class TypeFieldsNode extends ASTNode {
    private String name;
    private List<FieldDeclarationNode> fields;

    public TypeFieldsNode(String name, List<FieldDeclarationNode> fields) {
        this.name = name;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public List<FieldDeclarationNode> getFields() {
        return fields;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitTypeFields(this);
    }

    @Override
    public List<? extends ASTNode> getChildren() {
        return fields;
    }
}
