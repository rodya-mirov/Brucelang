package io.rodyamirov.brucelang.types;

public class NoneType implements ValueType {
    public static final NoneType NONE_TYPE = new NoneType();
    public static final String TYPE_NAME = "NoneType";

    private NoneType() {
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
