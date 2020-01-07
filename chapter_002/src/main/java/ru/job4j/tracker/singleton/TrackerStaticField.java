package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerStaticField {

    private static final Tracker TRACKER = new Tracker();

    private static TrackerStaticField instance;

    private TrackerStaticField() {
    }

    public static TrackerStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerStaticField();
        }
        return instance;
    }

    public Tracker getTracker() {
        return this.TRACKER;
    }
}
