package io.rodyamirov.brucelang.evaluation;

import io.rodyamirov.brucelang.ast.VariableDeclarationNode;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class ValueTable {
    private final Map<String, Object> storedValues;

    public ValueTable() {
        this.storedValues = new HashMap<>();
    }

    private ValueTable(ValueTable toCopy) {
        this.storedValues = new HashMap<>(toCopy.storedValues);
    }

    @Nonnull
    public Object getValue(VariableDeclarationNode variableDeclarationNode) {
        String fullName = variableDeclarationNode.getCanonicalName();
        Object value = storedValues.get(fullName);

        if (value == null) {
            throw new RuntimeException("Access before store! Static analysis should have prevented this!");
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

            this.valueTable.storedValues
                    .put(variableDeclarationNode.getCanonicalName(), value);

            return this;
        }

        public ValueTable build() {
            if (this.built) {
                throw new IllegalStateException("Cannot build twice!");
            }

            this.built = false;
            return valueTable;
        }
    }
}
