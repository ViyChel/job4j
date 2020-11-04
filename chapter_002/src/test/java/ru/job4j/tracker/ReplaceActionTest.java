package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class ReplaceActionTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.11.2020
 */
public class ReplaceActionTest {

    @Test
    public void whenReplaceDone() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = mock(Input.class);
        UserAction rep = new ReplaceAction();
        when(input.askStr(any(String.class))).thenReturn(item.getId()).thenReturn(replacedName);
        rep.execute(input, tracker);
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenReplaceFail() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input input = mock(Input.class);
        UserAction rep = new ReplaceAction();
        when(input.askStr(any(String.class))).thenReturn("").thenReturn("Enter a new name of item: ");
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
        assertThat(out.toString(), is("Invalid id of item selected!" + ln));
        System.setOut(def);
    }
}