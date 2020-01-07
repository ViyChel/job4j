package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerStaticFinal {

    private static final TrackerStaticFinal INSTANCE = new TrackerStaticFinal();

    private static final Tracker TRACKER = new Tracker();

    private TrackerStaticFinal() {
    }

    public static TrackerStaticFinal getInstance() {
        return INSTANCE;
    }

    public Tracker getTracker() {
        return this.TRACKER;
    }
}
