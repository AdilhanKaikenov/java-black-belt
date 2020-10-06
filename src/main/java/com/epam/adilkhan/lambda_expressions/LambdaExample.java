package com.epam.adilkhan.lambda_expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        Student student1 = new Student("Masha", 20, 2, 5.6);
        Student student2 = new Student("Petr", 23, 4, 7.9);
        Student student3 = new Student("Natasha", 21, 3, 9.2);
        Student student4 = new Student("Max", 19, 1, 6.7);

        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(student1, student2, student3, student4));

        Collections.sort(students, (s1, s2) -> s1.getCourse() - s2.getCourse());
        System.out.println(students);
        System.out.println("==============================================");

        filterStudentsByCheck(students, (Student student) -> {return student.getAge() <= 20;});
        System.out.println("==============================================");
        filterStudentsByCheck(students, (Student student) -> {return student.getAvgGrade() > 7;});
        System.out.println("==============================================");
        filterStudentsByCheck(students, (Student student) -> {return student.getAge() > 22&&student.getCourse()>2;});
    }

    private static void filterStudentsByCheck(List<Student> students, StudentCheck studentCheck) {
        for (Student student : students) {
            if (studentCheck.check(student)) {
                System.out.println(student);
            }
        }
    }
}



