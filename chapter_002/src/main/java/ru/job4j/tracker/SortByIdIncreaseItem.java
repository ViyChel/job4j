package ru.job4j.tracker;

import java.util.Comparator;

/**
 * The SortByIdIncreaseItem class sorts Item objects by id in ascending order.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 13.01.2020
 */

public class SortByIdIncreaseItem implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
