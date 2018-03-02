package io.rodyamirov.brucelang.evaluation;

import io.rodyamirov.brucelang.ast.FieldDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.util.collections.Stack;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ValueTable {
    private final Map<String, Object> storedValues;

    public ValueTable(Map<String, Consumer<Stack<Object>>> nativeExprs) {
        this.storedValues = new HashMap<>(nativeExprs);
    }

    private ValueTable(ValueTable toCopy) {
        this.storedValues = new HashMap<>(toCopy.storedValues);
    }

    @Nonnull
    public Object getValue(VariableDeclarationNode variableDeclarationNode) {
        return getValue(variableDeclarationNode.getCanonicalName());
    }

    @Nonnull
    public Object getValue(FieldDeclarationNode fieldDeclarationNode) {
        return getValue(fieldDeclarationNode.getCanonicalName());
    }

    @Nonnull
    private Object getValue(String fullName) {
        Object value = storedValues.get(fullName);

        if (value == null) {
            throw new RuntimeException(
                    String.format("Accessed value '%s' but no value was stored!", fullName));
        }

        return value;
    }

    public ValueTableModifier withChanges() {
        return new ValueTableModifier(this);
    }

    public class ValueTableModifier {
        // TODO: this is terribly inefficient (copy on write); consider a smarter implementation
        private ValueTable valueTable;
        private boolean built;

        private ValueTableModifier(ValueTable original) {
            this.valueTable = new ValueTable(original);
            this.built = false;
        }

        public ValueTableModifier storeValue(VariableDeclarationNode variableDeclarationNode, Object value) {
            if (this.built) {
                throw new IllegalStateException("Cannot modify after building!");
            }

            Object oldValue = this.valueTable.storedValues
                    .put(variableDeclarationNode.getCanonicalName(), value);

            if (oldValue != null) {
                throw new IllegalStateException("Cannot modify a stored value, for any reason!");
            }

            return this;
        }

        public ValueTable build() {
            if (this.built) {
                throw new IllegalStateException("Cannot build twice!");
            }

            this.built = true;
            return valueTable;
        }
    }
}
