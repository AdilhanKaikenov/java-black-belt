package com.epam.adilkhan.lambda_expressions.predicate;

import com.epam.adilkhan.lambda_expressions.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Student student1 = new Student("Masha", 20, 2, 5.6);
        Student student2 = new Student("Petr", 23, 4, 7.9);
        Student student3 = new Student("Natasha", 21, 3, 9.2);
        Student student4 = new Student("Max", 19, 1, 6.7);

        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(student1, student2, student3, student4));

        filterStudentsByCheck(students, (Student student) -> { return student.getAge() <= 20; });
        System.out.println("==============================================");
        filterStudentsByCheck(students, (Student student) -> { return student.getAvgGrade() > 7; });

        System.out.println("==============================================");
        filterStudentsByCheck(students, (Student student) -> { return student.getAge() > 22 && student.getCourse() > 2; });
        System.out.println("==============================================");
        Predicate<Student> predicate1 = student -> student.getAge() > 22;
        Predicate<Student> predicate2 = student -> student.getCourse() > 2;
        filterStudentsByCheck(students, predicate1.and(predicate2));
        System.out.println("==============================================");
        filterStudentsByCheck(students, predicate1.negate());
    }

    private static void filterStudentsByCheck(List<Student> students, Predicate<Student> predicate) {
        for (Student student : students) {
            if (predicate.test(student)) {
                System.out.println(student);
            }
        }
    }
}
