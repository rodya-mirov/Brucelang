package io.rodyamirov.brucelang.types;

public class ActionType implements ValueType {
    public static final ActionType ACTION_TYPE = new ActionType();
    public static final String TYPE_NAME = "Action";

    private ActionType() {
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
