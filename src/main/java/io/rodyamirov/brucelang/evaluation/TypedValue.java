package io.rodyamirov.brucelang.evaluation;

import io.rodyamirov.brucelang.ast.TypeReferenceNode;

public class TypedValue {
    private final TypeReferenceNode type;
    private final Object value;

    public TypedValue(TypeReferenceNode type, Object value) {
        this.type = type;
        this.value = value;
    }

    public TypeReferenceNode getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }
}
