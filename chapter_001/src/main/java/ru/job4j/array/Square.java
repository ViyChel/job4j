package ru.job4j.array;

import java.util.Scanner;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }
        return rst;
    }
}
