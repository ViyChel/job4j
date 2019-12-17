package ru.job4j.array;


public class Square {
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) Math.pow(i + 1, 2);
        }
        return result;
    }
}
