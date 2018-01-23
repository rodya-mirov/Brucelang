package io.rodyamirov.brucelang.astexceptions;

import io.rodyamirov.brucelang.ast.ASTNode;

/**
 * General class of exceptions for "something funny happened when processing the AST"
 */
public class AstException extends RuntimeException {
    private final ASTNode troubleNode;

    protected AstException(ASTNode troubleNode, String message) {
        super(message);

        this.troubleNode = troubleNode;
    }
}
