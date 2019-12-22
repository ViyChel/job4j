package ru.job4j.poly;

public interface Transport {
    void go();

    void people(int amount);

    Double fill(int fuel);
}
