package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }

    List<Address> collectUnique(List<Address> addresses) {
        return addresses.stream().distinct().collect(Collectors.toList());
    }

    void sorted(List<Address> addresses) {
        addresses.sort(new SortByCityAddress());
    }
}
