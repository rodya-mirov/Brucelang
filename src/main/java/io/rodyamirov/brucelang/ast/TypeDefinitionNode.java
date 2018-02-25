package io.rodyamirov.brucelang.ast;

import java.util.List;

public class TypeDeclarationNode extends StatementNode {
    private List<FieldDeclarationNode> fields;

    public TypeDeclarationNode(List<FieldDeclarationNode> fields) {
        this.fields = fields;
    }

    public List<FieldDeclarationNode> getFields() {
        return fields;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitTypeDeclaration(this);
    }

    @Override
    public List<FieldDeclarationNode> getChildren() {
        return fields;
    }
}
