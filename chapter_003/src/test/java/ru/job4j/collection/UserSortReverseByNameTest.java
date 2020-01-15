package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class UserSortReverseByNameTest {
    @Test
    public void whenComparatorByNameReverse() {
        Comparator<User> comparator = new UserSortReverseByName();
        int rsl = comparator.compare(new User("Oleg", 27), new User("Danil", 15));
        assertThat(rsl, lessThan(0));
    }
}
