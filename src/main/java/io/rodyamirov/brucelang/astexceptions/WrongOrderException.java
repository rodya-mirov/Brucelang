package io.rodyamirov.brucelang.astexceptions;

import io.rodyamirov.brucelang.ast.ASTNode;

public class WrongOrderException extends AstException {
    public WrongOrderException(ASTNode troubleNode, String message) {
        super(troubleNode, message);
    }
}
