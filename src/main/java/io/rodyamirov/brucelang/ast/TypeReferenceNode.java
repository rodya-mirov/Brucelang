package io.rodyamirov.brucelang.ast;

import javax.annotation.Nonnull;

/**
 * A TypeReference is the declared (or determined) type of an expression or variable.
 * SimpleTypeReferences must resolve to a declaration, while derived references are made up of
 * simple types under certain rules, and
 */
// NB: i wish we had enum classes in Java because this is tailor made for that
public abstract class TypeReferenceNode extends ASTNode {

    public static boolean equalTypes(TypeReferenceNode a, TypeReferenceNode b) {
        if (a == null) {
            return b == null;
        } else if (b == null) {
            return false;
        } else {
            return a.sameType(b);
        }
    }

    protected abstract boolean sameType(@Nonnull TypeReferenceNode other);

    public abstract <T> T acceptTR(TypeReferenceNodeVisitor<T> visitor);

    public interface TypeReferenceNodeVisitor<T> {
        T visitTypeRefTypeFunc(TypeFuncTypeRefNode typeFuncTypeRef);
        T visitSimpleTypeRef(SimpleTypeReferenceNode simpleTypeReference);
        T visitParametrizedTypeRef(ParametrizedTypeReferenceNode parametrizedTypeReference);
        T visitFuncTypeRef(FunctionTypeReferenceNode functionTypeReference);
    }
}
