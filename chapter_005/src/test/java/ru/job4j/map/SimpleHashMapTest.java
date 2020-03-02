package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    private SimpleHashMap<String, Integer> map;

    @Before
    public void init() {
        map = new SimpleHashMap<>();
        map.insert("Petr", 28);
        map.insert("Vasya", 17);
        map.insert("Ivan", 26);
    }

    @Test
    public void checkIncreaseTable() {
        map.insert("A", 28);
        map.insert("B", 28);
        map.insert("C", 28);
        map.insert("D", 28);
        map.insert("E", 28);
        map.insert("F", 28);
        map.insert("G", 28);
        map.insert("H", 28);
        map.insert("I", 17);
        map.insert("J", 26);
        map.insert("K", 26);
        map.insert("L", 26);
        map.insert("M", 26);
        map.insert("M", 26);
        map.insert("M", 26);
        assertThat(map.getTableLength(), is(32));
    }

    @Test
    public void whenHashProducesSameHashCode() {
        int expected = map.hash("Lena");
        assertThat(expected, is(2364712));
        int expectedRepeat = map.hash("Lena");
        assertThat(expectedRepeat, is(2364712));
    }

    @Test
    public void insertCheck() {
        assertThat(map.getSize(), is(3));
        map.insert("Oleg", 36);
        assertThat(map.getSize(), is(4));
    }

    @Test
    public void getWhenItemExist() {
        int expected = map.get("Vasya");
        assertThat(expected, is(17));
    }

    @Test
    public void getWhenItemDoesNotExist() {
        assertNull(map.get("Vova"));
    }

    @Test
    public void deleteWhenItemExist() {
        assertTrue(map.delete("Ivan"));
    }

    @Test
    public void deleteWhenItemDoesNotExist() {
        assertFalse(map.delete("Semen"));
    }
}