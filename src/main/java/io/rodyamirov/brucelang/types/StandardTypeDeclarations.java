package io.rodyamirov.brucelang.types;

import java.util.ArrayList;
import java.util.List;

public class StandardTypeDeclarations {
    public static final String FUNCTION = "Fn";
    public static final String INTEGER = "Integer";
    public static final String BOOLEAN = "Boolean";
    public static final String STRING = "String";
    public static final String NONE = "None";

    // NB: this is an illegal type name so is guaranteed to be interpreter-generated
    public static final String INFERRED = "!INFERRED!";

    private StandardTypeDeclarations() {
    }

    public static ComplexTypeDeclaration makeFunctionType(
            List<TypeDeclaration> paramTypes,
            TypeDeclaration returnType) {

        List<TypeDeclaration> typeArgs = new ArrayList<>(paramTypes.size() + 1);
        typeArgs.addAll(paramTypes);
        typeArgs.add(returnType);
        return new ComplexTypeDeclaration(FUNCTION, typeArgs);
    }

    public static SimpleTypeDeclaration makeIntegerType() {
        return new SimpleTypeDeclaration(INTEGER);
    }

    public static SimpleTypeDeclaration makeBooleanType() {
        return new SimpleTypeDeclaration(BOOLEAN);
    }

    public static SimpleTypeDeclaration makeStringType() {
        return new SimpleTypeDeclaration(STRING);
    }

    public static SimpleTypeDeclaration makeNoneType() {
        return new SimpleTypeDeclaration(NONE);
    }

    public static SimpleTypeDeclaration makeInferredType() {
        return new SimpleTypeDeclaration(INFERRED);
    }
}
