package io.rodyamirov.brucelang.types;

public interface Type {
    boolean isSameType(Type other);
    String getTypeName();

    default boolean isUnknown() {
        return this.isSameType(UnknownType.UNKNOWN_TYPE);
    }
}
