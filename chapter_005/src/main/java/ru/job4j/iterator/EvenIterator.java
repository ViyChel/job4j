package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIterator
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.02.2020
 */
public class EvenIterator implements Iterator {

    private final int[] array;
    private int index = 0;

    /**
     * Instantiates a new Even iterator.
     *
     * @param array the array
     */
    public EvenIterator(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (this.array.length > index) {
            if (this.array[index] % 2 == 0) {
                result = true;
                break;
            } else {
                index++;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return this.array[index++];
        }
    }
}

