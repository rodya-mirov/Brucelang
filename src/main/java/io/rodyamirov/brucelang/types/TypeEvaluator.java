package io.rodyamirov.brucelang.types;

import io.rodyamirov.brucelang.NotImplementedException;
import io.rodyamirov.brucelang.ast.FunctionTypeReferenceNode;
import io.rodyamirov.brucelang.ast.ParametrizedTypeReferenceNode;
import io.rodyamirov.brucelang.ast.SimpleTypeReferenceNode;
import io.rodyamirov.brucelang.ast.TypeFuncTypeRefNode;
import io.rodyamirov.brucelang.ast.TypeReferenceNode;

import java.util.List;
import java.util.stream.Collectors;

public class TypeEvaluator {
    private TypeEvaluator() {
    }

    public static TypeReferenceNode evaluate(
            TypeFuncTypeRefNode typeFuncTypeRef, List<TypeReferenceNode> arguments) {

        return typeFuncTypeRef.getResultType()
                .acceptTR(new TypeFuncApplier(typeFuncTypeRef.getTypeParameters(), arguments));
    }

    private static class TypeFuncApplier implements TypeReferenceNode.TypeReferenceNodeVisitor<TypeReferenceNode> {
        private final List<SimpleTypeReferenceNode> parameters;
        private final List<TypeReferenceNode> arguments;

        private TypeFuncApplier(List<SimpleTypeReferenceNode> parameters, List<TypeReferenceNode> arguments) {
            if (parameters.size() != arguments.size()) {
                throw new IllegalArgumentException(); // this should have been checked earlier
            }

            this.parameters = parameters;
            this.arguments = arguments;
        }

        @Override
        public TypeFuncTypeRefNode visitTypeRefTypeFunc(TypeFuncTypeRefNode typeFuncTypeRef) {
            TypeReferenceNode newReturnType = typeFuncTypeRef.getResultType().acceptTR(this);

            // type parameters cannot be changed, they're tied to the declarations
            TypeFuncTypeRefNode copy = new TypeFuncTypeRefNode(typeFuncTypeRef.getTypeParameters(), newReturnType);
            copy.setNamespace(typeFuncTypeRef.getNamespace());

            return copy;
        }

        @Override
        public TypeReferenceNode visitSimpleTypeRef(SimpleTypeReferenceNode simpleTypeReference) {
            for (int i = 0; i < parameters.size(); i++) {
                if (simpleTypeReference.sameType(parameters.get(i))) {
                    return arguments.get(i);
                }
            }

            return simpleTypeReference;
        }

        @Override
        public ParametrizedTypeReferenceNode visitParametrizedTypeRef(
                ParametrizedTypeReferenceNode parametrizedTypeReference) {

            throw new NotImplementedException(); // we don't have parametrized types, just parametrized variables, for now
        }

        @Override
        public FunctionTypeReferenceNode visitFuncTypeRef(FunctionTypeReferenceNode functionTypeReference) {
            List<TypeReferenceNode> newParameters = functionTypeReference.getArguments().stream()
                    .map(tr -> tr.acceptTR(this))
                    .collect(Collectors.toList());

            TypeReferenceNode newReturnType = functionTypeReference.getReturnType().acceptTR(this);

            FunctionTypeReferenceNode copy = new FunctionTypeReferenceNode(newParameters, newReturnType);
            copy.setNamespace(functionTypeReference.getNamespace());

            return copy;
        }
    }
}
