package ru.job4j.stream;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void whenAsc() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivanov", 67));
        students.add(new Student("Semenov", 35));
        students.add(new Student(null, 0));
        students.add(new Student("Fedin", 89));
        students.add(new Student("Volkov", 58));
        students.add(new Student(null, 0));
        students.add(new Student("Morozov", 16));
        List<Student> result = Student.levelOf(students, 34);
        List<Student> expected = List.of(
                new Student("Fedin", 89),
                new Student("Ivanov", 67),
                new Student("Volkov", 58),
                new Student("Semenov", 35));
        assertThat(expected, is(result));
    }
}
