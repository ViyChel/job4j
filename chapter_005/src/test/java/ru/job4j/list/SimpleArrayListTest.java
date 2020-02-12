package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void init() {
        this.list = new SimpleArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);
        this.list.add(5);
        this.list.add(6);
        this.list.add(7);
        this.list.add(8);
        this.list.add(9);
        this.list.add(10);
    }

    @Test
    public void whenAddElement() {
        assertThat(this.list.get(0), is(1));
        assertThat(this.list.get(1), is(2));
    }

    @Test
    public void whenAddMoreThanTenElements() {
        this.list.add(11);
        assertThat(this.list.get(10), is(11));
    }

    @Test
    public void whenSizeListTenElements() {
        assertThat(this.list.getSize(), is(10));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorThrowCMException() {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            this.list.add(11);
        }
    }
}