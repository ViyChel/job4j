package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square() {
        int perimeter = 4;
        int multiplier = 1;
        double expected = 1;
        double out = SqArea.square(perimeter, multiplier);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void square2() {
        int perimeter = 6;
        int multiplier = 2;
        double expected = 2;
        double out = SqArea.square(perimeter, multiplier);
        Assert.assertEquals(expected, out, 0.01);
    }
}
