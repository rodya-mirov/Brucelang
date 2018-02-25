package io.rodyamirov.brucelang.types;

import io.rodyamirov.brucelang.ast.TypeReferenceNode;
import io.rodyamirov.brucelang.staticanalysis.Namespace;

import java.util.ArrayList;
import java.util.List;

public class StandardTypeReferences {
    public static final String INTEGER = "Integer";
    public static final String BOOLEAN = "Boolean";
    public static final String STRING = "String";

    private StandardTypeReferences() {
    }

    public static TypeReferenceNode.FunctionTypeReferenceNode makeFunctionType(
            List<TypeReferenceNode> paramTypes,
            TypeReferenceNode returnType,
            Namespace namespace) {

        List<TypeReferenceNode> typeArgs = new ArrayList<>(paramTypes.size());
        typeArgs.addAll(paramTypes);

        TypeReferenceNode.FunctionTypeReferenceNode out = new TypeReferenceNode.FunctionTypeReferenceNode(typeArgs, returnType);
        out.setNamespace(namespace);
        return out;
    }

    public static TypeReferenceNode.SimpleTypeReferenceNode makeIntegerType(Namespace namespace) {
        TypeReferenceNode.SimpleTypeReferenceNode out = new TypeReferenceNode.SimpleTypeReferenceNode(INTEGER);
        out.setNamespace(namespace);
        return out;
    }

    public static TypeReferenceNode.SimpleTypeReferenceNode makeBooleanType(Namespace namespace) {
        TypeReferenceNode.SimpleTypeReferenceNode out = new TypeReferenceNode.SimpleTypeReferenceNode(BOOLEAN);
        out.setNamespace(namespace);
        return out;
    }

    public static TypeReferenceNode.SimpleTypeReferenceNode makeStringType(Namespace namespace) {
        TypeReferenceNode.SimpleTypeReferenceNode out = new TypeReferenceNode.SimpleTypeReferenceNode(STRING);
        out.setNamespace(namespace);
        return out;
    }
}
