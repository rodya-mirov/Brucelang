package io.rodyamirov.brucelang.ast;

public interface Typed {
    TypeReferenceNode getType();
    void setType(TypeReferenceNode type);
}
