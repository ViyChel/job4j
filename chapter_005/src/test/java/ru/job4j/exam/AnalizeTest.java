package ru.job4j.exam;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {
    Analize analize;
    List<Analize.User> previous;
    List<Analize.User> current;

    @Before
    public void init() {
        analize = new Analize();
        previous = new ArrayList<>();
        current = new ArrayList<>();
    }

    @Test
    public void whenDeletedTwoElement() {
        previous.add(new Analize.User(1, "A"));
        previous.add(new Analize.User(10, "B"));
        previous.add(new Analize.User(13, "C"));
        previous.add(new Analize.User(4, "D"));
        previous.add(new Analize.User(5, "E"));
        current.add(new Analize.User(1, "A"));
        current.add(new Analize.User(13, "C"));
        current.add(new Analize.User(4, "D"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(
                info.deleted,
                is(2));
    }

    @Test
    public void whenAddedTwoAndDeleteTwoElement() {
        previous.add(new Analize.User(1, "A"));
        previous.add(new Analize.User(10, "B"));
        previous.add(new Analize.User(13, "C"));
        current.add(new Analize.User(13, "C"));
        current.add(new Analize.User(7, "F"));
        current.add(new Analize.User(8, "G"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.deleted, is(2));
        assertThat(info.added, is(2));
    }

    @Test
    public void whenChangedOneElement() {
        previous.add(new Analize.User(1, "A"));
        previous.add(new Analize.User(10, "B"));
        current.add(new Analize.User(1, "A"));
        current.add(new Analize.User(10, "G"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.changed, is(1));
    }
}