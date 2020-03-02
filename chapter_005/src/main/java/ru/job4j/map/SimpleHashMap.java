package ru.job4j.map;

import java.util.*;

/**
 * Class SimpleHashMap
 *
 * @param <K> <V> the type parameters
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.03.2020
 */
public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {
    private Node<K, V>[] table;
    /**
     * The Default load factor.
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    private int modCount;

    /**
     * Instantiates a new Simple hash map.
     */
    public SimpleHashMap() {
        this.table = new Node[16];
    }

    /**
     * Hash int.
     *
     * @param key the key
     * @return the int
     */
    final int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    private int indexFor(int hash) {
        return (this.table.length - 1) & hash;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets table length.
     *
     * @return the table length
     */
    int getTableLength() {
        return table.length;
    }

    /**
     * Get table node [ ].
     *
     * @return the node [ ]
     */

    private void checkSizeTable() {
        if (this.size >= this.table.length * DEFAULT_LOAD_FACTOR) {
            resize();
        }
    }

    private void resize() {
        Node<K, V>[] oldTable = this.table;
        modCount++;
        table = new Node[oldTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                insert(node.getKey(), node.getValue());
            }
        }
    }

    /**
     * Insert boolean.
     *
     * @param key   the key
     * @param value the value
     * @return the boolean
     */
    boolean insert(K key, V value) {
        checkSizeTable();
        boolean result = false;
        int hash = hash(key);
        int i = indexFor(hash);
        if (this.table[i] == null) {
            this.table[i] = new Node<>(hash, key, value);
            this.size++;
            this.modCount++;
            result = true;
        }
        return result;
    }


    /**
     * Get v.
     *
     * @param key the key
     * @return the v
     */
    V get(K key) {
        V result = null;
        int hash = hash(key);
        Node<K, V> node = table[indexFor(hash)];
        if (node != null && (node.getKey() == key)) {
            result = node.getValue();
        }
        return result;
    }

    /**
     * Delete boolean.
     *
     * @param key the key
     * @return the boolean
     */
    boolean delete(K key) {
        boolean result = false;
        Node<K, V> node = table[indexFor(hash(key))];
        if (node != null && (node.getKey() == key)) {
            table[indexFor(hash(key))] = null;
            result = true;
        }
        this.size--;
        this.modCount--;
        return result;
    }

    @Override
    public Iterator<SimpleHashMap.Node<K, V>> iterator() {
        return new SimpleHashMap<K, V>.Itr();
    }

    private class Itr implements Iterator<Node<K, V>> {
        private int index = 0;
        private int position = 0;
        /**
         * The Expected mod count.
         */
        int expectedModCount = modCount;

        /**
         * Instantiates a new Itr.
         */

        @Override
        public boolean hasNext() {
            return size > index;
        }

        @Override
        public Node<K, V> next() {
            checkForComodification();
            Node<K, V> result = null;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            for (int i = position; i < table.length; i++) {
                if (table[i] != null) {
                    result = table[i];
                    index++;
                    position = ++i;
                    break;
                }
            }
            return result;
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
     * The type Node.
     *
     * @param <K> the type parameter
     * @param <V> the type parameter
     */
    static class Node<K, V> {
        /**
         * The Hash.
         */
        final int hash;
        /**
         * The Key.
         */
        final K key;
        /**
         * The Value.
         */
        V value;

        /**
         * Instantiates a new Node.
         *
         * @param hash  the hash
         * @param key   the key
         * @param value the value
         */
        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key)
                    && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        /**
         * Gets hash.
         *
         * @return the hash
         */
        public int getHash() {
            return hash;
        }

        /**
         * Gets key.
         *
         * @return the key
         */
        public K getKey() {
            return key;
        }

        /**
         * Gets value.
         *
         * @return the value
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets value.
         *
         * @param value the value
         */
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{"
                    + " key=" + key
                    + ", value=" + value
                    + '}';
        }
    }
}

