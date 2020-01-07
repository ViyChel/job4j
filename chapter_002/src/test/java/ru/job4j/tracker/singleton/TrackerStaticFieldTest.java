package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TrackerStaticFieldTest {

    @Test
    public void checkSingleObject() {
        TrackerStaticField trackerOne = TrackerStaticField.getInstance();
        TrackerStaticField trackerTwo = TrackerStaticField.getInstance();
        assertSame(trackerOne, trackerTwo);
    }
}
