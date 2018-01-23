package io.rodyamirov.brucelang.ast;

/**
 * Static class for enums and other information about operators.
 *
 * In a less dogmatically-OO language this would just be a module.
 */
public final class Operators {
    private Operators() {
        // do nothing
    }

    public enum BinOp {
        PLUS, MINUS, TIMES, DIVIDE,
        LT, LTE, GT, GTE, EQ, NEQ,
        AND, OR
    }

    public enum UnOp {
        NEG
    }
}
