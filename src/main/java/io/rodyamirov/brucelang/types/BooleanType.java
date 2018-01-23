package io.rodyamirov.brucelang.types;

public class BooleanType implements ValueType {
    public static final BooleanType BOOLEAN_TYPE = new BooleanType();
    public static final String TYPE_NAME = "Boolean";

    private BooleanType() {
    }

    @Override
    public boolean isSameType(Type other) {
        return this == other;
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
