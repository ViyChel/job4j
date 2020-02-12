package ru.job4j.generic;

import ru.job4j.iterator.SimpleIterator;

import java.util.Iterator;

/**
 * Class SimpleArray
 *
 * @param <T> the type parameter
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 09.02.2020
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * The Array.
     */
    private Object[] array;
    /**
     * The Index.
     */
    private int index = 0;

    /**
     * Instantiates a new Simple array.
     *
     * @param size the size
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Add.
     *
     * @param model the model
     */
    public void add(T model) {
        if (array.length == index) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index++] = model;
    }

    /**
     * Set.
     *
     * @param position the index
     * @param model    the model
     */
    public void set(int position, T model) {
        if (position < 0 || position >= this.array.length) {
            throw new IndexOutOfBoundsException();
        }
        this.array[position] = model;
    }

    /**
     * Remove.
     *
     * @param position the index
     */
    public void remove(int position) {
        if (position < 0 || position >= this.array.length) {
            throw new IndexOutOfBoundsException();
        } else if (position == index - 1) {
            this.array[index - 1] = null;
        } else {
            System.arraycopy(this.array, position + 1, this.array, position, index - position - 1);
        }
        index--;
    }

    /**
     * Get element of array.
     *
     * @param position the index
     * @return the T
     */
    public T get(int position) {
        if (position < 0 || position >= this.array.length) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.array[position];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleIterator<>(this.array);
    }
}

