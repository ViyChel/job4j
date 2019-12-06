package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        int count = 0;
        for (int i = 1; i <= finish; i++) {
            if (i == 1) continue;
            if (checkPrimeNumber.check(i)) {
                System.out.println(i);
                count++;
            }
        }

        return count;
    }
}