package ru.job4j.stream;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

public class MatrixTest {

    @Test
    public void whenArrayToList() {
        Integer[][] numbers = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = Matrix.convertToList(numbers);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expected));
    }
}
