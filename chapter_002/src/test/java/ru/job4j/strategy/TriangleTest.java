package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vitaly Yagufarov
 * @version 1.0
 * @since 24.12.2019
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   +").append(System.lineSeparator())
                                .append("  + +").append(System.lineSeparator())
                                .append(" +   +").append(System.lineSeparator())
                                .append("+++++++").append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
