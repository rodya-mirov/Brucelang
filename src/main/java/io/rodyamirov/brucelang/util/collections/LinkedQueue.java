package io.rodyamirov.brucelang.util.collections;

import java.util.LinkedList;

public class LinkedQueue<T> extends LinkedList<T> implements Queue<T> {
    public LinkedQueue() {
        super();
    }

    @Override
    public T dequeue() {
        return removeFirst();
    }

    @Override
    public void enqueue(T t) {
        add(t);
    }
}
