package io.rodyamirov.brucelang.util.collections;

import java.util.function.Consumer;

public interface Queue<T> {
    int size();
    T dequeue();
    void enqueue(T t);

    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Process the entire queue. Dequeues elements sequentially and applies the processor to them.
     * The element processor has access to a function that enqueues elements safely onto the end
     * of the queue.
     *
     * @param processor Function object which processes elements
     */
    default void process(QueueProcessor<T> processor) {
        while (!isEmpty()) {
            processor.processElement(dequeue(), this::enqueue);
        }
    }

    @FunctionalInterface
    interface QueueProcessor<T> {
        void processElement(T element, Consumer<T> enqueuer);
    }
}
