package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Let's go!");
    }

    @Override
    public void people(int amount) {
        System.out.println("We have passengers " + amount);
    }

    @Override
    public Double fill(int fuel) {
        double summ = 150;
        return summ / fuel;
    }
}
