package io.rodyamirov.brucelang.ast;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ParametrizedTypeReferenceNode extends TypeReferenceNode {
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
    public <T> T acceptTR(TypeReferenceNodeVisitor<T> visitor) {
        return visitor.visitParametrizedTypeRef(this);
    }

    @Override
    public List<? extends ASTNode> getChildren() {
        List<TypeReferenceNode> out = new ArrayList<>(arguments.size() + 1);
        out.add(baseReference);
        out.addAll(arguments);

        return out;
    }

    @Override
    protected boolean sameType(@Nonnull TypeReferenceNode o) {
        if (!(o instanceof ParametrizedTypeReferenceNode)) {
            return false;
        }

        ParametrizedTypeReferenceNode other = (ParametrizedTypeReferenceNode) o;

        IntPredicate sameArg = i ->
                equalTypes(this.arguments.get(i), other.arguments.get(i));

        return this.baseReference.sameType(other.baseReference)
                && this.arguments.size() == other.arguments.size()
                && IntStream.range(0, this.arguments.size()).allMatch(sameArg);
    }
}
