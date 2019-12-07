package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int finish) {
        boolean prime = false;
        if (finish / 1 == finish) prime = true;
        for (int i = 2; i < finish; i++) {
            if (finish % i == 0) {
                prime = false;
                break;
            }
            prime = true;
        }
        return prime;
    }
}