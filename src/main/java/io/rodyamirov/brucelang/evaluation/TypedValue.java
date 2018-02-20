package io.rodyamirov.brucelang.evaluation;

import io.rodyamirov.brucelang.types.TypeDeclaration;

public class TypedValue {
    private final TypeDeclaration type;
    private final Object value;

    public TypedValue(TypeDeclaration type, Object value) {
        this.type = type;
        this.value = value;
    }

    public TypeDeclaration getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }
}
