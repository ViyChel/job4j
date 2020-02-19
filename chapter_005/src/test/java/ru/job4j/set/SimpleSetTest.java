package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    private SimpleSet<Integer> set = new SimpleSet<>();

    @Test
    public void whenAddElementUnique() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        int result = 0;
        for (Integer element : set) {
            if (element.equals(1)) {
                result++;
            }
        }
        assertThat(result, is(1));
    }
}