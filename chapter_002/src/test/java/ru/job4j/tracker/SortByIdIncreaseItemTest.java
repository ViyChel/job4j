package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortByIdIncreaseItemTest {

    @Test
    public void whenSortByIdDecrease() {
        Item item1 = new Item("bug1");
        Item item2 = new Item("bug1");
        Item item3 = new Item("bug1");
        Item item4 = new Item("bug1");
        item1.setId("45265874");
        item2.setId("4569455487");
        item3.setId("1256");
        item4.setId("-56987");
        List<Item> items = Arrays.asList(item1, item2, item3, item4);
        List<Item> expected = Arrays.asList(item4, item3, item1, item2);
        Collections.sort(items, new SortByIdIncreaseItem());
        assertThat(expected, is(items));
    }
}
