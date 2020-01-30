package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupTest {

    @Test
    public void checkStudens() {
        List<Student> students = List.of(
                new Student("Ivanov", Set.of("boxing", "karate")),
                new Student("Petrov", Set.of("boxing", "judo", "swimming")),
                new Student("Semenov", Set.of("swimming")),
                new Student("Romanov", Set.of("boxing", "karate", "judo", "swimming"))
        );
        Map<String, Set<String>> result = Group.sections(students);
        Map<String, Set<String>> expected = Map.of(
                "swimming", Set.of("Romanov", "Petrov", "Semenov"),
                "karate", Set.of("Romanov", "Ivanov"),
                "judo", Set.of("Romanov", "Petrov"),
                "boxing", Set.of("Romanov", "Petrov", "Ivanov")
        );
        assertThat(result, is(expected));
    }
}
