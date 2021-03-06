package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindByNameAction act = new FindByNameAction();
        act.execute(new StubInput(new String[]{item.getName()}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(item.getId() + " " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenFindByNameTrueUsesMockito() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        Input input = mock(Input.class);
        UserAction act = new FindByNameAction();
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        String expected = item.getId() + " " + item.getName() + System.lineSeparator();
        assertThat(act.execute(input, tracker), is(true));
        assertThat(out.toString(), is(expected));
        System.setOut(def);
    }

    @Test
    public void whenFindByNameFalseUsesMockito() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        Input input = mock(Input.class);
        UserAction act = new FindByNameAction();
        when(input.askStr(any(String.class))).thenReturn("-1");
        String expected = "Items not found!" + System.lineSeparator();
        assertThat(act.execute(input, tracker), is(false));
        assertThat(out.toString(), is(expected));
        System.setOut(def);
    }

}
