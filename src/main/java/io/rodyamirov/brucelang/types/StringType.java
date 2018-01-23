package io.rodyamirov.brucelang.types;

public class StringType implements ValueType {
    public static final StringType STRING_TYPE = new StringType();
    public static final String TYPE_NAME = "String";

    private StringType() {
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
