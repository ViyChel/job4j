package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double expected = 2;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance2() {
        Point a = new Point(2, 5);
        Point b = new Point(1, 3);
        double expected = 2.23606797749979;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
