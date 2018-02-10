package io.rodyamirov.brucelang.util.collections;

public interface Queue<T> {
    int size();
    T dequeue();
    void enqueue(T t);
}
