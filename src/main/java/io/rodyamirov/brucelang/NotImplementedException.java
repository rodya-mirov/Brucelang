package io.rodyamirov.brucelang;

import java.util.function.Consumer;

// A marker for "I didn't do this yet"
// Don't merge anything with >0 usages of this, probably?
public class NotImplementedException extends RuntimeException {
    public static <T> Consumer<T> thrown() {
        return t -> {
            throw new NotImplementedException();
        };
    }
}
