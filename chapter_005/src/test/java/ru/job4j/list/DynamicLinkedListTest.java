package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicLinkedListTest {
    private DynamicLinkedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetIndexMoreThanSize() {
        list.get(5);
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