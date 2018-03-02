package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.astexceptions.DoubleDefinitionException;
import io.rodyamirov.brucelang.astexceptions.NameNotDefinedException;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// just the spec of a type, but this creates a new namespace for its children, which is why we need it
public class TypeFieldsNode extends ASTNode {
    private String name;
    private List<FieldDeclarationNode> fields;
    private Map<String, FieldDeclarationNode> fieldMap;

    public TypeFieldsNode(String name, List<FieldDeclarationNode> fields) {
        this.name = name;
        this.fields = fields;
        this.fieldMap = makeFieldMap(fields);
    }

    private static Map<String, FieldDeclarationNode> makeFieldMap(List<FieldDeclarationNode> fields) {
        Map<String, FieldDeclarationNode> fieldMap = new HashMap<>();
        for (FieldDeclarationNode field : fields) {
            Object oldValue = fieldMap.put(field.getName(), field);
            if (oldValue != null) {
                throw new DoubleDefinitionException(field, "Field '%s' is already defined!", field.getName());
            }
        }
        return fieldMap;
    }

    public String getName() {
        return name;
    }

    public List<FieldDeclarationNode> getFields() {
        return fields;
    }

    public String getCanonicalName() {
        return getNamespace().getFullName();
    }

    public void setFields(List<FieldDeclarationNode> fields) {
        this.fields = fields;
        this.fieldMap = makeFieldMap(fields);
    }

    @Nonnull
    public FieldDeclarationNode getField(String fieldName) {
        FieldDeclarationNode out = fieldMap.get(fieldName);
        if (out == null) {
            throw new NameNotDefinedException(this.getNamespace(), this.name + "::" + fieldName);
        }
        return out;
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
