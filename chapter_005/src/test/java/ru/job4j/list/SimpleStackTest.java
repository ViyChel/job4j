package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleStackTest {
    private SimpleStack<Integer> stack = new SimpleStack<>();

    @Before
    public void init() {
        stack.push(2);
        stack.push(4);
        stack.push(6);
    }

    @Test
    public void whehAddThreeElementAndPollThreeElement() {
        assertThat(stack.poll(), is(6));
        assertThat(stack.poll(), is(4));
        assertThat(stack.poll(), is(2));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenAddThreeItemsAndPollFourTimesException() {
        stack.poll();
        stack.poll();
        stack.poll();
        stack.poll();
    }
}