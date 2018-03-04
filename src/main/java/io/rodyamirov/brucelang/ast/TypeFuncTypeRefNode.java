package io.rodyamirov.brucelang.ast;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * A type reference which is itself a function; something like (T) -> Fn(T, Integer)
 * which, when you feed it a type (say, String), you get an unqualified type (here,
 * Fn(String, Integer))
 */
public class TypeFuncTypeRefNode extends TypeReferenceNode {
    private List<SimpleTypeReferenceNode> typeParameters;
    private TypeReferenceNode resultType;

    public TypeFuncTypeRefNode(
            List<SimpleTypeReferenceNode> typeParameters,
            TypeReferenceNode resultType) {
        this.typeParameters = typeParameters;
        this.resultType = resultType;
    }

    public List<SimpleTypeReferenceNode> getTypeParameters() {
        return typeParameters;
    }

    public TypeReferenceNode getResultType() {
        return resultType;
    }

    @Override
    protected boolean sameType(@Nonnull TypeReferenceNode o) {
        if (!(o instanceof TypeFuncTypeRefNode)) {
            return false;
        }

        TypeFuncTypeRefNode other = (TypeFuncTypeRefNode) o;

        IntPredicate sameArg = i ->
                equalTypes(this.typeParameters.get(i), other.typeParameters.get(i));

        return this.typeParameters.size() == other.typeParameters.size()
                && IntStream.range(0, this.typeParameters.size()).allMatch(sameArg)
                && this.resultType.sameType(other.resultType);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitTypeFuncTypeRef(this);
    }

    @Override
    public <T> T acceptTR(TypeReferenceNodeVisitor<T> visitor) {
        return visitor.visitTypeRefTypeFunc(this);
    }

    @Override
    public List<? extends ASTNode> getChildren() {
        List<TypeReferenceNode> out = new ArrayList<>(typeParameters.size() + 1);
        out.addAll(typeParameters);
        out.add(resultType);
        return out;
    }
}
