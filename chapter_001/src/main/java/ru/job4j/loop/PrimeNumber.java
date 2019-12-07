package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        int count = 0;
        for (int i = 2; i <= finish; i++) {
            if (checkPrimeNumber.check(i)) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }
}