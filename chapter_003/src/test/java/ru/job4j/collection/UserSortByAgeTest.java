package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class UserSortByAgeTest {
    @Test
    public void whenComparatorByAge() {
        Comparator<User> comparator = new UserSortByAge();
        int rsl = comparator.compare(new User("Oleg", 27), new User("Danil", 15));
        assertThat(rsl, greaterThan(0));
    }
}
