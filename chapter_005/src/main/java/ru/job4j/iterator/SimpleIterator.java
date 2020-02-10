package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleIterator
 *
 * @param <T> the type parameter
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 09.02.2020
 */
public class SimpleIterator<T> implements Iterator<T> {

    private final Object[] array;
    private int index = 0;

    /**
     * Instantiates a new Simple iterator.
     *
     * @param array the array
     */
    public SimpleIterator(final Object[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return this.array.length > index;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) this.array[index++];
    }
}
