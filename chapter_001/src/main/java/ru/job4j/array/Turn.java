package ru.job4j.array;

import java.util.Arrays;

public class Turn {
    public int[] back(int[] array) {
        for (int index = 0; index < array.length - index - 1; index++) {
            int tmp = array[array.length - index - 1];
            array[array.length - index - 1] = array[index];
            array[index] = tmp;
        }
        return array;
    }
}
