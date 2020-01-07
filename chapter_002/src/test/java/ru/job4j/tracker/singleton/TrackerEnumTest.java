package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TrackerEnumTest {

    @Test
    public void checkSingleObject() {
        TrackerEnum trackerOne = TrackerEnum.INSTANCE;
        TrackerEnum trackerTwo = TrackerEnum.INSTANCE;
        assertSame(trackerOne, trackerTwo);
    }
}
