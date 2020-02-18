package ru.job4j.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {
    private SimpleQueue simpleQueue = new SimpleQueue();


    @Test
    public void whenThreeAddAndThreeTake() {
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoElement() {
        simpleQueue.poll();
    }
}