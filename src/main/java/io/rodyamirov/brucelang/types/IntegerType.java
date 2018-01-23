package io.rodyamirov.brucelang.types;

public class IntegerType implements ValueType {
    public static final IntegerType INTEGER_TYPE = new IntegerType();
    public static final String TYPE_NAME = "Integer";

    private IntegerType() {
    }

    @Override
    public boolean isSameType(Type other) {
        return this == other; // only one instance is possible
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }
}
