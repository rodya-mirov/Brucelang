package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.types.TypeDeclaration;

public interface Typed {
    TypeDeclaration getType();
    void setType(TypeDeclaration type);
}
