package io.rodyamirov.brucelang.util.functional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Replacement of Optional, because Optional doesn't have flatOrElse or flatOrElseGet
 * @param <T>
 */
public final class Maybe<T> {
    private final T value;

    private Maybe(T value) {
        this.value = value;
    }

    public static <T> Maybe<T> of(@Nonnull T value) {
        return new Maybe<>(value);
    }

    public static <T> Maybe<T> ofNullable(@Nullable T value) {
        return new Maybe<>(value);
    }

    public static <T> Maybe<T> empty() {
        return new Maybe<>((T) null);
    }

    public <T2> Maybe<T2> map(Function<T, T2> mapper) {
        return new Maybe<>(mapper.apply(value));
    }

    public <T2> Maybe<T2> flatMap(Function<T, Maybe<T2>> mapper) {
        if (value == null) {
            return Maybe.empty();
        } else {
            return mapper.apply(value);
        }
    }

    public Maybe<T> orElse(T newValue) {
        if (value == null) {
            return new Maybe<>(newValue);
        } else {
            return this;
        }
    }

    public Maybe<T> flatOrElse(Maybe<T> newValue) {
        if (value == null) {
            return newValue;
        } else {
            return this;
        }
    }

    public Maybe<T> orElseGet(Supplier<T> newValue) {
        if (value == null) {
            return new Maybe<>(newValue.get());
        } else {
            return this;
        }
    }

    public Maybe<T> flatOrElseGet(Supplier<Maybe<T>> newValue) {
        if (value == null) {
            return newValue.get();
        } else {
            return this;
        }
    }
}
