package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareHaveTwoPetr() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Petr", 16));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 16)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenCompatorByNameAndAge() {
        Comparator<User> cmpNamePriority = new UserSortByName().thenComparing(new UserSortByAge());
        int rsl = cmpNamePriority.compare(
                new User("Oleg", 27),
                new User("Oleg", 15)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameRevAndAgeRev() {
        Comparator<User> cmpNamePriority = new UserSortReverseByName().thenComparing(new UserSortReverseByAge());
        int rsl = cmpNamePriority.compare(
                new User("Oleg", 27),
                new User("Oleg", 15)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndAgeEquals() {
        Comparator<User> cmpNamePriority = new UserSortReverseByName().thenComparing(new UserSortReverseByAge());
        int rsl = cmpNamePriority.compare(
                new User("Oleg", 27),
                new User("Oleg", 27)
        );
        assertThat(rsl, is(0));
    }
}
