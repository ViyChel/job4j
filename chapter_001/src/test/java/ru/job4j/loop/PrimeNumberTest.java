package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PrimeNumberTest {
    @Test
    public void when5() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calculation(5);
        assertThat(count, is(3));
    }

    @Test
    public void when11() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calculation(11);
        assertThat(count, is(5));
    }

    @Test
    public void when2() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calculation(2);
        assertThat(count, is(1));
    }

    @Test
    public void when1() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calculation(1);
        assertThat(count, is(0));
    }
}