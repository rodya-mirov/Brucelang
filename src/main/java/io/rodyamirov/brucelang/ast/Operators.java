package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.types.StandardTypeDeclarations;
import io.rodyamirov.brucelang.types.TypeDeclaration;

import javax.annotation.Nullable;

import static io.rodyamirov.brucelang.types.TypeDeclaration.equalTypes;

/**
 * Static class for enums and other information about operators.
 *
 * In a less dogmatically-OO language this would just be a module.
 */
public final class Operators {
    private static final TypeDeclaration INTEGER_TYPE = StandardTypeDeclarations.makeIntegerType();
    private static final TypeDeclaration BOOLEAN_TYPE = StandardTypeDeclarations.makeBooleanType();
    private static final TypeDeclaration STRING_TYPE = StandardTypeDeclarations.makeStringType();

    private Operators() {
        // do nothing
    }

    public enum BinOp {
        PLUS, MINUS, TIMES, DIVIDE,
        LT, LTE, GT, GTE, EQ, NEQ,
        AND, OR;

        /**
         * Finds the return type of this operator, based on the types of the arguments.
         * Returns null if this operator is not defined on these arguments.
         */
        @Nullable
        public TypeDeclaration findOutputType(TypeDeclaration leftArg, TypeDeclaration rightArg) {
            switch (this) {
                case PLUS:
                case MINUS:
                case TIMES:
                case DIVIDE:
                    if (equalTypes(leftArg, INTEGER_TYPE) && equalTypes(rightArg, INTEGER_TYPE)) {
                        return INTEGER_TYPE;
                    } else {
                        return null;
                    }

                case LT:
                case LTE:
                case GT:
                case GTE:
                    if (equalTypes(leftArg, INTEGER_TYPE) && equalTypes(rightArg, INTEGER_TYPE)) {
                        return BOOLEAN_TYPE;
                    } else {
                        return null;
                    }

                case EQ:
                case NEQ:
                    if (equalTypes(leftArg, rightArg)) {
                        // TODO: this means EVERY TYPE IS EQUAL-ABLE; we probably don't want this?
                        return BOOLEAN_TYPE;
                    } else {
                        return null;
                    }

                case AND:
                case OR:
                    if (equalTypes(leftArg, BOOLEAN_TYPE) && equalTypes(rightArg, BOOLEAN_TYPE)) {
                        return BOOLEAN_TYPE;
                    } else {
                        return null;
                    }

                default:
                    throw new RuntimeException("Unhandled binary operation: " + this.toString());
            }
        }
    }

    public enum UnOp {
        NEG;

        /**
         * Finds the return type of this operator, based on the types of the arguments.
         * Returns null if this operator is not defined on these arguments.
         */
        @Nullable
        public TypeDeclaration findOutputType(TypeDeclaration childArg) {
            switch (this) {
                case NEG:
                    if (equalTypes(childArg, INTEGER_TYPE)) {
                        return INTEGER_TYPE;
                    } else {
                        return null;
                    }

                default:
                    throw new RuntimeException("Unhandled unary operation: " + this.toString());
            }
        }
    }
}
