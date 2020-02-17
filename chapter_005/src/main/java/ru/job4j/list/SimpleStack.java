package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Class SimpleStack
 *
 * @param <T> the type parameter
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 17.02.2020
 */
public class SimpleStack<T> {
    private SimpleLinkedList<T> list = new SimpleLinkedList<>();

    /**
     * Poll T.
     *
     * @return the t
     */
    public T poll() {
        if (list.getSize() == 0) {
            throw new NoSuchElementException();
        }
        return list.delete();
    }

    /**
     * Push.
     *
     * @param value the value
     */
    public void push(T value) {
        list.add(value);
    }
}

