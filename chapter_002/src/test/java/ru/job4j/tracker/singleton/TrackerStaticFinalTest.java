package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TrackerStaticFinalTest {

    @Test
    public void checkSingleObject() {
        TrackerStaticFinal trackerOne = TrackerStaticFinal.getInstance();
        TrackerStaticFinal trackerTwo = TrackerStaticFinal.getInstance();
        assertSame(trackerOne, trackerTwo);
    }
}
