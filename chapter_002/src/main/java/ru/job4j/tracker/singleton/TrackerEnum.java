package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public enum TrackerEnum {
    INSTANCE;  // здесь мы указываем перечисления.

    private static final Tracker TRACKER = new Tracker();

    public Tracker getTracker() {
        return this.TRACKER;
    }
}
