package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int finish) {
        boolean prime = false;
        for (int i = 1; i < finish; i++) {
            if (i == 1) {
                prime = true;
                continue;
            }
            if (finish % i == 0) {
                prime = false;
                break;
            }
            prime = true;
        }
        return prime;
    }
}