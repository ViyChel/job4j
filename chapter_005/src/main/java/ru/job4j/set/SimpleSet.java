package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;

/**
 * Class SimpleSet
 *
 * @param <E> the type parameter
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 18.02.2020
 */

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArrayList<E> list = new SimpleArrayList();

    void add(E value) {
        if (contains(value)) {
            this.list.add(value);
        }
    }

    public boolean contains(E value) {
        boolean result = true;
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).equals(value)) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}

