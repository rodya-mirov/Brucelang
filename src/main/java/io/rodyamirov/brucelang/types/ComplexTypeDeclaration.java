package io.rodyamirov.brucelang.types;

import java.util.ArrayList;
import java.util.List;

public class ComplexTypeDeclaration implements TypeDeclaration {
    private final String typeName;
    private final List<TypeDeclaration> typeArguments;

    public ComplexTypeDeclaration(String typeName, List<TypeDeclaration> typeArguments) {
        this.typeName = typeName;
        this.typeArguments = new ArrayList<>(typeArguments);
    }

    @Override
    public String typeName() {
        return typeName;
    }

    @Override
    public boolean isSimpleType() {
        return false;
    }

    @Override
    public List<TypeDeclaration> typeArguments() {
        return typeArguments;
    }
}
