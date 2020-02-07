package ru.job4j.iterator;

import java.util.*;

/**
 * Class Converter
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 06.02.2020
 */
public class Converter {
    /**
     * Convert iterator.
     *
     * @param it the it
     * @return Iterator
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {

            private Iterator<Integer> temp = it.next();

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !temp.hasNext()) {
                    temp = it.next();
                }
                return temp.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return temp.next();
            }
        };
    }
}