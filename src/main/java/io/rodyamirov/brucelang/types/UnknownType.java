package io.rodyamirov.brucelang.types;

/**
 * Type indicating that we could not determine the type of the associated node
 */
public class UnknownType implements Type {
    public static final UnknownType UNKNOWN_TYPE = new UnknownType();
    public static final String TYPE_NAME = "(Unknown Type)";

    private UnknownType() {
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
