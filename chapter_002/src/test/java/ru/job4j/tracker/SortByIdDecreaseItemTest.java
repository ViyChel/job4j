package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByIdDecreaseItemTest {

    @Test
    public void whenSortByIdDecrease() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("bug1"));
        tracker.add(new Item("bug2"));
        tracker.add(new Item("bug3"));
        tracker.add(new Item("bug4"));
        ArrayList<Item> items = tracker.findAll();
        System.out.println("Список до сортировки");
        for (Item value : items) {
            System.out.println(value.getId() + "  " + value.getName());
        }
        Collections.sort(items, new SortByIdDecreaseItem());
        System.out.println();
        System.out.println("Список после сортировки");
        for (Item value : items) {
            System.out.println(value.getId() + "  " + value.getName());
        }
    }
}
