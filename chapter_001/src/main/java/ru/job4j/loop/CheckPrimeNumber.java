package ru.job4j.loop;

class CheckPrimeNumber {
    boolean check(int finish) {
        boolean prime = true;
        if (finish == 1) {
            return false;
        }
        for (int i = 2; i < finish; i++) {
            if (finish % i == 0) {
                return false;
            }
        }
        return prime;
    }
}