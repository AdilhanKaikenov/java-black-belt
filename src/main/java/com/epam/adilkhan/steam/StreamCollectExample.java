package com.epam.adilkhan.steam;

import com.epam.adilkhan.lambda_expressions.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectExample {
    public static void main(String[] args) {
        Student student1 = new Student("Masha", 20, 2, 5.6);
        Student student2 = new Student("Petr", 23, 4, 7.9);
        Student student3 = new Student("Natasha", 21, 3, 9.2);
        Student student4 = new Student("Max", 19, 1, 6.7);
        Student student5 = new Student("Ira", 23, 4, 8.3);

        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(student1, student2, student3, student4, student5));

        // groupingBy example
        Map<Integer, List<Student>> map1 = students.stream().map(student -> {
            student.setName(student.getName().toUpperCase());
            return student;
        }).collect(Collectors.groupingBy(student -> student.getCourse()));

        for (Map.Entry<Integer, List<Student>> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("\n======================================================\n");

        // partitioningBy example
        Map<Boolean, List<Student>> map2 = students.stream()
                .collect(Collectors.partitioningBy(student -> student.getAvgGrade() > 7));

        for (Map.Entry<Boolean, List<Student>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
