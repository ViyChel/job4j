package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProfilesTest {
    private List<Profile> list = new ArrayList<>();

    @Before
    public void fillList() {
        list.add(new Profile(new Address("Moscow", "Pushkina", 28, 45)));
        list.add(new Profile(new Address("London", "Lenina", 5, 17)));
        list.add(new Profile(new Address("Kirov", "Darvina", 46, 125)));
        list.add(new Profile(new Address("Orsk", "Lavrovaya", 17, 87)));
    }

    @Test
    public void collectProfiles() {
        List<Address> result = list.stream().map(Profile::getAddress).collect(Collectors.toList());
        List<Address> expected = List.of(
                new Address("Moscow", "Pushkina", 28, 45),
                new Address("London", "Lenina", 5, 17),
                new Address("Kirov", "Darvina", 46, 125),
                new Address("Orsk", "Lavrovaya", 17, 87));
        assertThat(result, is(expected));
    }
}
