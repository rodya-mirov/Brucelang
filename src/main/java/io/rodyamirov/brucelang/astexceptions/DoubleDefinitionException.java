package io.rodyamirov.brucelang.astexceptions;

import io.rodyamirov.brucelang.ast.ASTNode;

public class DoubleDefinitionException extends AstException {
    public DoubleDefinitionException(ASTNode troubleNode, String message, Object... args) {
        super(troubleNode, args.length == 0 ? message : String.format(message, args));
    }
}
