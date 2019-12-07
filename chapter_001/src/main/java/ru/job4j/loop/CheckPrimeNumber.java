package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int finish) {
        boolean prime = true;
        if (finish == 1) return false;
        for (int i = 2; i < finish; i++) {
            if (finish % i == 0) {
                return false;
            }
        }
        return prime;
    }
}