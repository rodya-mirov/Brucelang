package io.rodyamirov.brucelang.astexceptions;

import io.rodyamirov.brucelang.ast.ASTNode;

/**
 * Exception indicating there was an issue with types; the message should be useful
 */
public class WrongTypeException extends AstException {
    public WrongTypeException(ASTNode troubleNode, String message, Object... args) {
        super(troubleNode, args.length == 0 ? message : String.format(message, args));
    }
}
