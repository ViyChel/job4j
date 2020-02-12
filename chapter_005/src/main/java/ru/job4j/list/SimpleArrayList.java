package ru.job4j.list;

import java.util.*;

/**
 * Class SimpleArrayList
 *
 * @param <E> the type parameter
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 12.02.2020
 */
public class SimpleArrayList<E> implements Iterable<E> {

    private Object[] container;
    private int size;
    private int capacity = 10;
    private int modCount;

    /**
     * Instantiates a new Simple array list.
     */
    public SimpleArrayList() {
        this.container = new Object[this.capacity];
    }

    /**
     * Add.
     *
     * @param value the value
     */
    public void add(E value) {
        modCount++;
        if (size == capacity - 1) {
            this.capacity = (int) Math.round(capacity * 1.5) + 1;
            Object[] tempContainer = this.container;
            this.container = new Object[this.capacity];
            System.arraycopy(tempContainer, 0, this.container, 0, tempContainer.length);
            this.container[size++] = value;
        } else {
            this.container[size++] = value;
        }
    }

    /**
     * Get e.
     *
     * @param index the index
     * @return the e
     */
    public E get(int index) {
        return (E) this.container[index];
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int index = 0;
        /**
         * The Expected mod count.
         */
        int expectedModCount = modCount;

        /**
         * Instantiates a new Itr.
         */
        Itr() {
        }

        @Override
        public boolean hasNext() {
            return container.length > index;
        }

        @Override
        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) container[index++];
        }

        /**
         * Check for comodification.
         */
        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}

