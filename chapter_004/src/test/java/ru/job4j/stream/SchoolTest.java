package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();
    private School school;

    @Before
    public void addStudent() {
        school = new School();
        students.add(new Student(75));
        students.add(new Student(100));
        students.add(new Student(15));
        students.add(new Student(45));
        students.add(new Student(80));
        students.add(new Student(65));
        students.add(new Student(35));
        students.add(new Student(50));
    }

    @Test
    public void whenStudentsScoreRange0to50() {
        List<Student> result = school.collect(students, s -> s.getScore() > 0 && s.getScore() < 50);
        List<Student> expected = List.of(new Student(15), new Student(45), new Student(35));
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsScoreRange50to70() {
        List<Student> result = school.collect(students, s -> s.getScore() >= 50 && s.getScore() < 70);
        List<Student> expected = List.of(new Student(65), new Student(50));
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsScoreRange70to100() {
        List<Student> result = school.collect(students, s -> s.getScore() >= 70 && s.getScore() <= 100);
        List<Student> expected = List.of(new Student(75), new Student(100), new Student(80));
        assertThat(result, is(expected));
    }
}
