package io.rodyamirov.brucelang.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

// NB: i wish we had enum classes in Java because this is tailor made for that
public abstract class TypeReferenceNode extends ASTNode {
    private TypeReferenceNode() {
        // to seal the class to the extensions specified below
    }

    public static boolean equalTypes(TypeReferenceNode a, TypeReferenceNode b) {
        if (a == null) {
            return b == null;
        } else if (b == null || a.getClass() != b.getClass()) {
            return false;
        } else if (a instanceof SimpleTypeReferenceNode) {
            return ((SimpleTypeReferenceNode) a).sameType((SimpleTypeReferenceNode) b);
        } else if (a instanceof ParametrizedTypeReferenceNode) {
            return ((ParametrizedTypeReferenceNode) a).sameType((ParametrizedTypeReferenceNode) b);
        } else if (a instanceof FunctionTypeReferenceNode) {
            return ((FunctionTypeReferenceNode) a).sameType((FunctionTypeReferenceNode) b);
        } else {
            throw new UnsupportedOperationException(
                    String.format("Cannot determine equality for '%s'", a.getClass().getCanonicalName()));
        }
    }

    public static final class SimpleTypeReferenceNode extends TypeReferenceNode {
        private String name;

        public SimpleTypeReferenceNode(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void accept(ASTVisitor visitor) {
            visitor.visitSimpleTypeReference(this);
        }

        @Override
        public List<? extends ASTNode> getChildren() {
            return Collections.emptyList();
        }

        public TypeDeclarationNode getDeclaration() {
            return getNamespace().getTypeDeclaration(name);
        }

        private boolean sameType(SimpleTypeReferenceNode other) {
            // reference equality is intentional
            return this.getDeclaration() == other.getDeclaration();
        }
    }

    public static final class FunctionTypeReferenceNode extends TypeReferenceNode {
        private List<TypeReferenceNode> arguments;
        private TypeReferenceNode returnType;

        public FunctionTypeReferenceNode(List<TypeReferenceNode> arguments, TypeReferenceNode returnType) {
            this.arguments = arguments;
            this.returnType = returnType;
        }

        public List<TypeReferenceNode> getArguments() {
            return arguments;
        }

        public TypeReferenceNode getReturnType() {
            return returnType;
        }

        @Override
        public void accept(ASTVisitor visitor) {
            visitor.visitFunctionTypeReference(this);
        }

        @Override
        public List<? extends TypeReferenceNode> getChildren() {
            List<TypeReferenceNode> out = new ArrayList<>(arguments.size() + 1);
            out.addAll(arguments);
            out.add(returnType);
            return out;
        }

        private boolean sameType(FunctionTypeReferenceNode other) {
            IntPredicate sameArg = i ->
                    equalTypes(this.arguments.get(i), other.arguments.get(i));

            return this.arguments.size() == other.arguments.size()
                    && equalTypes(this.returnType, other.returnType)
                    && IntStream.range(0, this.arguments.size()).allMatch(sameArg);
        }
    }

    public static final class ParametrizedTypeReferenceNode extends TypeReferenceNode {
        private SimpleTypeReferenceNode baseReference;
        private List<TypeReferenceNode> arguments;

        public ParametrizedTypeReferenceNode(SimpleTypeReferenceNode baseReference, List<TypeReferenceNode> arguments) {
            this.baseReference = baseReference;
            this.arguments = arguments;
        }

        public SimpleTypeReferenceNode getBaseReference() {
            return baseReference;
        }

        public List<TypeReferenceNode> getArguments() {
            return arguments;
        }

        @Override
        public void accept(ASTVisitor visitor) {
            visitor.visitParametrizedTypeReference(this);
        }

        @Override
        public List<? extends ASTNode> getChildren() {
            List<TypeReferenceNode> out = new ArrayList<>(arguments.size() + 1);
            out.add(baseReference);
            out.addAll(arguments);

            return out;
        }

        private boolean sameType(ParametrizedTypeReferenceNode other) {
            IntPredicate sameArg = i ->
                    equalTypes(this.arguments.get(i), other.arguments.get(i));

            return this.baseReference.sameType(other.baseReference)
                    && this.arguments.size() == other.arguments.size()
                    && IntStream.range(0, this.arguments.size()).allMatch(sameArg);
        }
    }
}
