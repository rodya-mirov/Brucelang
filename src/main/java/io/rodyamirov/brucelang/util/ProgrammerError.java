package io.rodyamirov.brucelang.util;

/**
 * Class for situations which ALWAYS indicate a software bug, and which cannot possibly be normal
 * operation or an externally created issue.
 */
public class ProgrammerError extends RuntimeException {
    public ProgrammerError() {
        super();
    }

    public ProgrammerError(String formatString, Object... args) {
        super(args.length == 0 ? formatString : String.format(formatString, args));
    }
}
