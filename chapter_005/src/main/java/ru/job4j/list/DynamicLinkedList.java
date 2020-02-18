package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class DynamicLinkedList
 *
 * @param <E> the type parameter
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 13.02.2020
 */

public class DynamicLinkedList<E> implements Iterable<E> {
    private int size;
    private Node<E> head;
    private int modCount;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        this.modCount++;
        if (head == null) {
            this.head = new Node<>(data);
        } else {
            Node<E> temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node<E>(data));
        }
        this.size++;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node<E> temp = head;
        while (temp != null) {
            if (currentIndex == index) {
                return (E) temp.getValue();
            }
            temp = temp.getNext();
            currentIndex++;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int index = 0;
        Node<E> result = head;
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
            return size > index;
        }

        @Override
        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            result = result.getNext();
            index++;
            return result.getValue();
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

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        private E value;
        private Node<E> next;

        Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}

