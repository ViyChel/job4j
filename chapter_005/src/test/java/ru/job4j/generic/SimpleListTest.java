package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;


public class SimpleListTest {

    public class A {
    }

    public class B extends A {
    }

    public class C extends B {
    }

    public void wildTest() {
        SimpleList<? super A> listA = new SimpleList<>(10);
        listA.add(new A());
        listA.add(new B());
        listA.add(new C());

        print(listA);
//        printUpper(listA);
        printLower(listA);
    }

    public void print(SimpleList<?> list) {
        //
    }

    public void printUpper(SimpleList<? extends B> list) {
        //
    }

    public void printLower(SimpleList<? super B> list) {
        //
    }

    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleList<String> simle = new SimpleList<>(4);
        simle.add("test");
        String result = simle.get(0);
        assertThat(result, is("test"));
    }

    @Test
    public void whenTypeIntShouldReturnInt() {
        SimpleList<Integer> simle = new SimpleList<>(4);
        simle.add(5);
        Integer result = simle.get(0);
        assertThat(result, is(5));
    }
}