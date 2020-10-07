package com.epam.adilkhan.steam;

import com.epam.adilkhan.lambda_expressions.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {
    public static void main(String[] args) {
        Student student1 = new Student("Masha", 20, 2, 5.6);
        Student student2 = new Student("Petr", 23, 4, 7.9);
        Student student3 = new Student("Natasha", 21, 3, 9.2);
        Student student4 = new Student("Max", 19, 1, 6.7);

        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(student1, student2, student3, student4));

        students = students.stream()
                .filter(element -> element.getAge() < 22 && element.getAvgGrade() < 7.2)
                .collect(Collectors.toList());

        System.out.println(students);
    }
}
