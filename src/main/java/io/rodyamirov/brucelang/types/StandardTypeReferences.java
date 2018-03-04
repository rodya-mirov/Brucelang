package io.rodyamirov.brucelang.types;

import io.rodyamirov.brucelang.ast.FunctionTypeReferenceNode;
import io.rodyamirov.brucelang.ast.SimpleTypeReferenceNode;
import io.rodyamirov.brucelang.ast.TypeDeclarationNode;
import io.rodyamirov.brucelang.ast.TypeFuncTypeRefNode;
import io.rodyamirov.brucelang.ast.TypeReferenceNode;
import io.rodyamirov.brucelang.staticanalysis.Namespace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StandardTypeReferences {
    public static final String INTEGER = "Integer";
    public static final String BOOLEAN = "Boolean";
    public static final String STRING = "String";

    private StandardTypeReferences() {
    }

    public static FunctionTypeReferenceNode makeFunctionType(
            List<TypeReferenceNode> paramTypes,
            TypeReferenceNode returnType,
            Namespace namespace) {

        List<TypeReferenceNode> typeArgs = new ArrayList<>(paramTypes.size());
        typeArgs.addAll(paramTypes);

        FunctionTypeReferenceNode out = new FunctionTypeReferenceNode(typeArgs, returnType);
        out.setNamespace(namespace);
        return out;
    }

    public static TypeFuncTypeRefNode makeTypeFunctionType(
            List<TypeDeclarationNode> params,
            TypeReferenceNode returnType,
            Namespace namespace) {

        List<SimpleTypeReferenceNode> typeParams = params.stream()
                .map(decl -> makeDirectReference(decl, namespace))
                .collect(Collectors.toList());

        TypeFuncTypeRefNode out = new TypeFuncTypeRefNode(typeParams, returnType);
        out.setNamespace(namespace);

        return out;
    }

    public static SimpleTypeReferenceNode makeIntegerType(Namespace namespace) {
        SimpleTypeReferenceNode out = new SimpleTypeReferenceNode(INTEGER);
        out.setNamespace(namespace);
        return out;
    }

    public static SimpleTypeReferenceNode makeBooleanType(Namespace namespace) {
        SimpleTypeReferenceNode out = new SimpleTypeReferenceNode(BOOLEAN);
        out.setNamespace(namespace);
        return out;
    }

    public static SimpleTypeReferenceNode makeStringType(Namespace namespace) {
        SimpleTypeReferenceNode out = new SimpleTypeReferenceNode(STRING);
        out.setNamespace(namespace);
        return out;
    }

    public static SimpleTypeReferenceNode makeDirectReference(TypeDeclarationNode declarationNode, Namespace namespace) {
        SimpleTypeReferenceNode out = new SimpleTypeReferenceNode(declarationNode.getName());
        out.setNamespace(namespace);
        return out;
    }
}
