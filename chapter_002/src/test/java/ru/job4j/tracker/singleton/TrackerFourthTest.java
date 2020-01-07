package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TrackerFourthTest {

    @Test
    public void checkSingleObject() {
        TrackerFourth trackerOne = TrackerFourth.getInstance();
        TrackerFourth trackerTwo = TrackerFourth.getInstance();
        assertSame(trackerOne, trackerTwo);
    }
}
