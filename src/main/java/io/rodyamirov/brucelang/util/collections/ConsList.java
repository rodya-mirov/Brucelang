package io.rodyamirov.brucelang.util.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Classic linked list implementation; here it's useful because everything involved is final, so
 * you can efficiently represent "many extensions" of the same list.
 *
 * This particular list is extended at the head, not the tail.
 */
public class ConsList<T> {
    public final boolean isEmpty;
    public final T element;
    public final ConsList<T> rest;

    public final int size;

    private ConsList(boolean isEmpty, T element, ConsList<T> rest) {
        this.isEmpty = isEmpty;
        this.element = element;
        this.rest = rest;

        if (isEmpty) {
            this.size = 0;
        } else {
            this.size = 1 + rest.size;
        }
    }

    public static <T> ConsList<T> empty() {
        return new ConsList<>(true, null, null);
    }

    public ConsList<T> extend(T headExtension) {
        return new ConsList<>(false, headExtension, this);
    }

    /**
     * Returns a List representation of this ConsList. Modifications to the returned list do not
     * affect this list, or subsequent invocations of this method.
     * @return A newly constructed list.
     */
    public List<T> toList() {
        List<T> out = new ArrayList<>(this.size);

        ConsList<T> list = this;
        while (list != null) {
            out.add(list.element);
            list = list.rest;
        }

        return out;
    }
}
