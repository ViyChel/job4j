package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class UserSortReverseByAgeTest {
    @Test
    public void whenComparatorByAge() {
        Comparator<User> comparator = new UserSortReverseByAge();
        int rsl = comparator.compare(new User("Oleg", 27), new User("Danil", 15));
        assertThat(rsl, lessThan(0));
    }
}
