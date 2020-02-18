package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    Node<Integer> first = new Node(1);
    Node<Integer> two = new Node(2);
    Node<Integer> third = new Node(3);
    Node<Integer> four = new Node(4);

    @Before
    public void init() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
    }

    @Test
    public void whenHasCycleTrue() {
        assertTrue(first.hasCycle(two));
    }

    @Test
    public void whenHasCycleFalse() {
        four.next = null;
        assertFalse(first.hasCycle(first));
    }

    @Test
    public void whenHasCycleTrue2() {
        third.next = two;
        assertTrue(first.hasCycle(two));
    }
}