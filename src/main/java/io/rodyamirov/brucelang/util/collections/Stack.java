package io.rodyamirov.brucelang.util.collections;

import java.util.EmptyStackException;

/**
 * Stack interface because the one built into the java standard lib is deprecated, and Deque
 * (the suggested replacement) is simultaneously a Queue and the methods are going to lead me to
 * confusion.
 *
 * @param <T> Type of the element
 */
public interface Stack<T> {
    void clear();

    void push(T t);

    T pop() throws EmptyStackException;

    default T popOr(T defaultValue) {
        if (this.size() == 0) {
            return defaultValue;
        } else {
            return this.pop();
        }
    }

    T peek() throws EmptyStackException;

    default T peekOr(T defaultValue) {
        if (this.size() == 0) {
            return defaultValue;
        } else {
            return this.peek();
        }
    }

    int size();
}
