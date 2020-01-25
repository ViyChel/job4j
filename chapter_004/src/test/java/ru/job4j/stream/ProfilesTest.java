package ru.job4j.stream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProfilesTest {
    private List<Profile> list;
    private List<Address> addressList;
    private Profiles profile;

    @Before
    public void fillAddressList() {
        profile = new Profiles();
        addressList = List.of(
                new Address("Moscow", "Pushkina", 28, 45),
                new Address("London", "Lenina", 5, 17),
                new Address("Kirov", "Darvina", 46, 125),
                new Address("Orsk", "Lavrovaya", 17, 87),
                new Address("Kirov", "Darvina", 46, 125)
        );
    }

    @Before
    public void fillList() {
        list = addressList.stream().map(Profile::new).collect(Collectors.toList());
    }

    @Test
    public void collectProfiles() {
        List<Address> result = profile.collect(list);
        assertThat(result, is(addressList));
    }

    @Test
    public void whenUnigueAddress() {
        List<Address> result = profile.collectUnique(addressList);
        List<Address> expected = List.of(
                new Address("Moscow", "Pushkina", 28, 45),
                new Address("London", "Lenina", 5, 17),
                new Address("Kirov", "Darvina", 46, 125),
                new Address("Orsk", "Lavrovaya", 17, 87)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenUnigueAndSortedByCity() {
        List<Address> result = profile.collectUnique(addressList);
        profile.sorted(result);
        List<Address> expected = List.of(
                new Address("Kirov", "Darvina", 46, 125),
                new Address("London", "Lenina", 5, 17),
                new Address("Moscow", "Pushkina", 28, 45),
                new Address("Orsk", "Lavrovaya", 17, 87)
        );
        assertThat(result, is(expected));
    }
}
