package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenMax1ofThree() {
        int result = Max.max(9, 2, 7);
        assertThat(result, is(9));
    }

    @Test
    public void whenMax2ofFour() {
        int result = Max.max(1, 8, 5, 3);
        assertThat(result, is(8));
    }

    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax1To2Then1() {
        int result = Max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax1To2Equals() {
        int result = Max.max(3, 3);
        assertThat(result, is(3));
    }

}
