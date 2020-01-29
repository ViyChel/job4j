package ru.job4j.stream;

<<<<<<< HEAD
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
=======
import java.util.Objects;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
>>>>>>> student
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
    public int getScope() {
        return scope;
    }

    static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
=======
    public int getScore() {
        return score;
>>>>>>> student
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
<<<<<<< HEAD
        return scope == student.scope
                && Objects.equals(name, student.name);
=======
        return Objects.equals(name, student.name);
>>>>>>> student
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(name, scope);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.getScope(), this.getScope());
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", scope=" + scope
                + '}';
=======
        return Objects.hash(name);
>>>>>>> student
    }
}
