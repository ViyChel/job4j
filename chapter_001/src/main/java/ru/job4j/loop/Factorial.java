package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                result = 1;
                continue;
            }
            result *= i;
        }
        return result;
    }
}
