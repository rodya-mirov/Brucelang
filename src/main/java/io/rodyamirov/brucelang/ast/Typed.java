package io.rodyamirov.brucelang.ast;

/**
 * Interface indicating a node (technically anything but intended for use by ASTNode extensions)
 * has an associated type. This is used for Expressions and VariableDeclarations, currently.
 */
public interface Typed {
    TypeReferenceNode getType();
    void setType(TypeReferenceNode type);
}
