package ru.job4j.collection.department;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start.isEmpty() ? el : start + "/" + el;
                tmp.add(start);
            }
        }
        List<String> result = new ArrayList<>(tmp);
        sortAsc(result);
        return result;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
