package ru.job4j.iterator;

import java.util.Iterator;

/**
 * The type Jagged array iterator.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 02.02.2019
 */
public class JaggedArrayIterator implements Iterator {

    private final int[][] array;
    private int indexArray = 0;
    private int index = 0;

    /**
     * Instantiates a new Jagged array iterator.
     *
     * @param array the array
     */
    public JaggedArrayIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length > indexArray;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int rsl = array[indexArray][index++];
        if (array[indexArray].length == index) {
            indexArray++;
            index = 0;
        }
        return rsl;
    }
}
