package ru.job4j.collection;

import java.util.Set;

public class UsageHashSet {
    public static void main(String[] args) {
        Set<String> autos = Set.of("Lada", "BMV", "Volvo", "Toyouta");
        for (String value : autos) {
            System.out.println(value);
        }
    }
}
