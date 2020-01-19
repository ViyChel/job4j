package ru.job4j.collection.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = o1.length() - o2.length();
        int length = Math.min(o1.length(), o2.length());

        for (int i = 0; i < length; i++) {
            int charCompare = Character.compare(o2.charAt(i), o1.charAt(i));
            if (charCompare != 0) {
                result = charCompare;
                break;
            }
        }
        return result;
    }
}