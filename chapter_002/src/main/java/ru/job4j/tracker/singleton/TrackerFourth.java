package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerFourth {

    private static final Tracker TRACKER = new Tracker();

    private TrackerFourth() {
    }

    public static TrackerFourth getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerFourth INSTANCE = new TrackerFourth();
    }

    public Tracker getTracker() {
        return this.TRACKER;
    }
}
