package io.rodyamirov.brucelang.ast;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FunctionTypeReferenceNode extends TypeReferenceNode {
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
    public <T> T acceptTR(TypeReferenceNodeVisitor<T> visitor) {
        return visitor.visitFuncTypeRef(this);
    }

    @Override
    public List<? extends TypeReferenceNode> getChildren() {
        List<TypeReferenceNode> out = new ArrayList<>(arguments.size() + 1);
        out.addAll(arguments);
        out.add(returnType);
        return out;
    }

    @Override
    protected boolean sameType(@Nonnull TypeReferenceNode o) {
        if (!(o instanceof FunctionTypeReferenceNode)) {
            return false;
        }

        FunctionTypeReferenceNode other = (FunctionTypeReferenceNode) o;

        IntPredicate sameArg = i ->
                this.arguments.get(i).sameType(other.arguments.get(i));

        return this.arguments.size() == other.arguments.size()
                && equalTypes(this.returnType, other.returnType)
                && IntStream.range(0, this.arguments.size()).allMatch(sameArg);
    }
}
