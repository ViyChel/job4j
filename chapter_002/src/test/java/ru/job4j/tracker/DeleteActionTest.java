package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class DeleteActionTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.11.2020
 */
public class DeleteActionTest {

    @Test
    public void whenRemoveTrue() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Removed item"));
        Input input = mock(Input.class);
        UserAction del = new DeleteAction();
        when(input.askStr(any(String.class))).thenReturn(item.getId());
        assertThat(del.execute(input, tracker), is(true));
        assertThat(out.toString(), is("=== Item was deleted ====" + System.lineSeparator()));
        System.setOut(def);
    }

    @Test
    public void whenRemoveFalse() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Removed item"));
        Input input = mock(Input.class);
        UserAction del = new DeleteAction();
        when(input.askStr(any(String.class))).thenReturn("-1");
        assertThat(del.execute(input, tracker), is(false));
        assertThat(out.toString(), is("Invalid id of item selected!" + System.lineSeparator()));
        System.setOut(def);
    }
}