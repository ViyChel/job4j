package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Peter Ivanovish");
        student.setGroup(3);
        student.setAdmissionDate(new Date());

        System.out.printf("Student %s is group %d, date of admission %s", student.getFullName(), student.getGroup(), student.getAdmissionDate());
    }
}
