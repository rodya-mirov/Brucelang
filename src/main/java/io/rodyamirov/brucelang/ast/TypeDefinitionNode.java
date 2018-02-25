package io.rodyamirov.brucelang.ast;

import java.util.ArrayList;
import java.util.List;

public class TypeDefinitionNode extends StatementNode {
    private TypeDeclarationNode declaration;
    private TypeFieldsNode fields;

    public TypeDefinitionNode(TypeDeclarationNode declaration, TypeFieldsNode fields) {
        this.declaration = declaration;
        this.fields = fields;
    }

    public TypeDeclarationNode getDeclaration() {
        return declaration;
    }

    public TypeFieldsNode getFields() {
        return fields;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitTypeDefinition(this);
    }

    @Override
    public List<? extends ASTNode> getChildren() {
        List<ASTNode> out = new ArrayList<>(2);
        out.add(declaration);
        out.add(fields);
        return out;
    }
}
