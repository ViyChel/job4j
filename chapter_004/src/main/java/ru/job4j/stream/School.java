package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    Map<String, Student> moveListToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getName, Function.identity(), (student, student2) -> student));
    }
}
