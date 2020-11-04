package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class FindByIdActionTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.11.2020
 */
public class FindByIdActionTest {

    @Test
    public void whenItemFound() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        Input input = mock(Input.class);
        UserAction act = new FindByIdAction();
        when(input.askStr(any(String.class))).thenReturn(item.getId());
        String ln = System.lineSeparator();
        String expected = "=== Item found by Id: " + item.getId() + " ===" + ln
                + item.getId() + " " + item.getName() + ln;
        assertThat(act.execute(input, tracker), is(true));
        assertThat(out.toString(), is(expected));
        System.setOut(def);
    }

    @Test
    public void whenItemNotFound() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        Input input = mock(Input.class);
        UserAction act = new FindByIdAction();
        when(input.askStr(any(String.class))).thenReturn("-1");
        String ln = System.lineSeparator();
        String expected = "Item not found!" + ln;
        assertThat(act.execute(input, tracker), is(false));
        assertThat(out.toString(), is(expected));
        System.setOut(def);
    }
}