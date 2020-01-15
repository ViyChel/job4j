package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class UserSortByNameTest {
    @Test
    public void whenComparatorByName() {
        Comparator<User> comparator = new UserSortByName();
        int rsl = comparator.compare(new User("Oleg", 27), new User("Danil", 15));
        assertThat(rsl, greaterThan(0));
    }
}
