package ru.job4j.tracker;

import java.util.Comparator;

/**
 * The SortByIdDecreaseItem class sorts Item objects by id in descending order.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 13.01.2020
 */


public class SortByIdDecreaseItem implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o2.getId().compareTo(o1.getId());
    }
}
