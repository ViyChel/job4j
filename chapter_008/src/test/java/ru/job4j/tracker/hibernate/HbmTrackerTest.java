package ru.job4j.tracker.hibernate;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Class HbmTrackerTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 31.01.2021
 */
public class HbmTrackerTest {
    final HbmTracker hbmTracker = new HbmTracker();

    @Test
    public void whenAddOneItem() {
        final Item item = new Item("item");
        hbmTracker.add(item);
        List<Item> items = hbmTracker.findAll();
        assertThat(items.size(), is(1));
        assertThat(items.get(0).getName(), is("item"));
        assertThat(items.get(0).getId(), is(1));
    }

    @Test
    public void whenChangeItemName() {
        final Item item = new Item("item");
        hbmTracker.add(item);
        item.setName("new name");
        hbmTracker.replace("1", item);
        assertThat(hbmTracker.findById("1").getName(), is("new name"));
    }

    @Test()
    public void whenAddTwoItemsThenDeleteOneItem() {
        final Item item = new Item("one");
        final Item item2 = new Item("two");
        hbmTracker.add(item);
        hbmTracker.add(item2);
        hbmTracker.delete("1");
        assertThat(hbmTracker.findAll().size(), is(1));
        assertThat(hbmTracker.findById("2").getName(), is("two"));
    }

    @Test
    public void whenAddOneItemThenItFindByID() {
        final Item item = new Item("item");
        hbmTracker.add(item);
        assertThat(hbmTracker.findById("1").getName(), is("item"));
    }

    @Test
    public void whenAddOneItemThenItFindByName() {
        final Item item = new Item("find");
        hbmTracker.add(item);
        List<Item> items = hbmTracker.findByName("find");
        assertThat(items.get(0).getName(), is("find"));
    }
}