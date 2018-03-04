package io.rodyamirov.brucelang.types;

import io.rodyamirov.brucelang.NotImplementedException;
import io.rodyamirov.brucelang.ast.SimpleTypeReferenceNode;
import io.rodyamirov.brucelang.ast.TypeDeclarationNode;
import io.rodyamirov.brucelang.ast.TypeFieldsNode;
import io.rodyamirov.brucelang.ast.TypeReferenceNode;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class TypeRegistry {
    private final Map<String, TypeFieldsNode> savedDefinitions;

    public TypeRegistry() {
        this.savedDefinitions = new HashMap<>();
    }

    private TypeRegistry(TypeRegistry toCopy) {
        this.savedDefinitions = new HashMap<>(toCopy.savedDefinitions);
    }

    @Nonnull
    public TypeFieldsNode getDefinition(TypeReferenceNode typeReference) {
        // TODO: downcasting is gross
        if (typeReference instanceof SimpleTypeReferenceNode) {
            String simpleName = ((SimpleTypeReferenceNode) typeReference).getName();
            TypeDeclarationNode declaration = typeReference.getNamespace().getTypeDeclaration(simpleName);
            String resolvedName = declaration.getCanonicalName();
            TypeFieldsNode savedDefinition = savedDefinitions.get(resolvedName);
            if (savedDefinition == null) {
                // probably a problem with the analysis, not the code
                throw new RuntimeException("No definition stored for type " + resolvedName);
            }
            return savedDefinition;
        } else {
            // haven't figured out how to resolve types like this ...
            throw new NotImplementedException();
        }
    }

    public TypeRegistry.TypeRegistryModifier withChanges() {
        return new TypeRegistry.TypeRegistryModifier(this);
    }

    public class TypeRegistryModifier {
        // TODO: this is terribly inefficient (copy on write); consider a smarter implementation
        private TypeRegistry typeRegistry;
        private boolean built;

        private TypeRegistryModifier(TypeRegistry original) {
            this.typeRegistry = new TypeRegistry(original);
            this.built = false;
        }

        public TypeRegistry.TypeRegistryModifier storeValue(TypeDeclarationNode declaration, TypeFieldsNode definition) {
            if (this.built) {
                throw new IllegalStateException("Cannot modify after building!");
            }

            Object oldValue = this.typeRegistry.savedDefinitions
                    .put(declaration.getCanonicalName(), definition);

            if (oldValue != null) {
                throw new IllegalStateException("Cannot modify a stored value, for any reason!");
            }

            return this;
        }

        public TypeRegistry build() {
            if (this.built) {
                throw new IllegalStateException("Cannot build twice!");
            }

            this.built = true;
            return this.typeRegistry;
        }
    }
}
