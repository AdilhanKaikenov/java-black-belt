package com.epam.adilkhan.lambda_expressions.function;

import com.epam.adilkhan.lambda_expressions.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Student student1 = new Student("Masha", 20, 2, 5.6);
        Student student2 = new Student("Petr", 23, 4, 7.9);
        Student student3 = new Student("Natasha", 21, 3, 9.2);
        Student student4 = new Student("Max", 19, 1, 6.7);

        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(student1, student2, student3, student4));

        Function<Student, Double> function = student -> student.getAvgGrade();

        double result = avgGrade(students, function);
        System.out.println(result);
    }

    private static double avgGrade(List<Student> students, Function<Student, Double> function) {
        double result = 0;
        for (Student student : students) {
            result += function.apply(student);
        }

        result = result / students.size();

        return result;
    }
}
