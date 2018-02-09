package io.rodyamirov.brucelang.types;

import java.util.List;

public class SimpleTypeDeclaration implements TypeDeclaration {
    private final String typeName;

    public SimpleTypeDeclaration(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String typeName() {
        return typeName;
    }

    @Override
    public boolean isSimpleType() {
        return true;
    }

    @Override
    public List<TypeDeclaration> typeArguments() {
        throw new UnsupportedOperationException();
    }
}
