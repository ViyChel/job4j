package ru.job4j.sort;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MachineTest {
    private Machine machine;

    @Before
    public void init(){
        machine = new Machine();
    }

    @Test
    public void whenEquals() {
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by35() {
        int[] expected = {10, 5};
        int[] rsl = machine.change(50, 35);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when100by35() {
        int[] expected = {10, 10, 10, 10, 10, 10, 5};
        int[] rsl = machine.change(100, 35);
        assertThat(rsl, is(expected));
    }
}
