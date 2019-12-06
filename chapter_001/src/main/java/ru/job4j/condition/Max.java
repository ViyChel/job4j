package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        int result = left;
        boolean condition = left > right;
        result = condition ? left : right;
        return result;
    }
}
