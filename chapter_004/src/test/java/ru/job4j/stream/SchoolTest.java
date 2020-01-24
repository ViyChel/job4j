package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();
    private School school;

    @Before
    public void addStudent() {
        school = new School();
        students.add(new Student("Ivanov", 75));
        students.add(new Student("Petrov", 100));
        students.add(new Student("Petrov", 88));
        students.add(new Student("Semenov", 15));
        students.add(new Student("Orlov", 45));
        students.add(new Student("Vesely", 80));
        students.add(new Student("Lomov", 65));
        students.add(new Student("Lomov", 66));
        students.add(new Student("Rodin", 35));
        students.add(new Student("Kozlov", 50));
    }

    @Test
    public void whenStudentsScoreRange0to50() {
        List<Student> result = school.collect(students, s -> s.getScore() > 0 && s.getScore() < 50);
        List<Student> expected = List.of(
                new Student("Semenov", 15),
                new Student("Orlov", 45),
                new Student("Rodin", 35));
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsScoreRange50to70() {
        List<Student> result = school.collect(students, s -> s.getScore() >= 50 && s.getScore() < 70);
        List<Student> expected = List.of(
                new Student("Lomov", 65),
                new Student("Lomov", 66),
                new Student("Kozlov", 50));
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsScoreRange70to100() {
        List<Student> result = school.collect(students, s -> s.getScore() >= 70 && s.getScore() <= 100);
        List<Student> expected = List.of(
                new Student("Ivanov", 75),
                new Student("Petrov", 100),
                new Student("Petrov", 88),
                new Student("Vesely", 80));
        assertThat(result, is(expected));
    }

    @Test
    public void whenListToMap() {
        Map<String, Student> map = school.moveListToMap(students);
        List<String> expected = List.of("Ivanov", "Petrov", "Semenov", "Orlov", "Vesely", "Lomov", "Rodin", "Kozlov");
        boolean result = true;
        for (String s : expected) {
            if (!map.containsKey(s)) {
                result = false;
                break;
            }
        }
        assertTrue(result && expected.size() == map.size());
    }
}