package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {
    private UserStore list;

    @Before
    public void init() {
        list = new UserStore(4);
    }

    @Test
    public void add() {
        list.add(new User("Vasya"));
        User result = this.list.findById("Vasya");
        assertThat(result.getId(), is("Vasya"));
    }

    @Test
    public void replace() {
        list.add(new User("Vasya"));
        boolean result = this.list.replace("Vasya", new User("Roman"));
        User user = this.list.findById("Roman");
        assertTrue(result);
        assertThat(user.getId(), is("Roman"));
    }

    @Test
    public void delete() {
        list.add(new User("Vasya"));
        User result = this.list.findById("Vasya");
        assertThat(result.getId(), is("Vasya"));
    }

    @Test
    public void findById() {
        list.add(new User("Vasya"));
        User result = this.list.findById("Vasya");
        assertThat(result.getId(), is("Vasya"));
    }
}