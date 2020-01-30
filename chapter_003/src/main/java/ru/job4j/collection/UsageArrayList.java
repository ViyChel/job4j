package ru.job4j.collection;

import java.util.List;

public class UsageArrayList {
    public static void main(String[] args) {
        List<String> strings = List.of("Petr", "Ivan", "Stepan");
        strings.forEach(System.out::println);
    }
}
