package io.rodyamirov.brucelang.util.collections;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack<T> extends ArrayList<T> implements Stack<T> {
    public ArrayStack() {
        super();
    }

    @Override
    public T pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        } else {
            return remove(size() - 1);
        }
    }

    @Override
    public T peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        } else {
            return get(size() - 1);
        }
    }

    @Override
    public void push(T t) {
        add(t);
    }
}
