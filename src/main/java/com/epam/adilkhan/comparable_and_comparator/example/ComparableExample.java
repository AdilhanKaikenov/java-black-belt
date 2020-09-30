package com.epam.adilkhan.comparable_and_comparator.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Sergey", "Petrov", 100_000);
        Employee employee3 = new Employee(3, "Zaur", "Tlegulov", 50_000);
        Employee employee4 = new Employee(4, "Sergey", "Sidorov", 400_000);
        Employee employee2 = new Employee(2, "Mariya", "Tlegulova", 250_000);

        // If Employee does not implement Comparable, the exception will be caught at runtime.
        // java.lang.ClassCastException: com.epam.adilkhan.comparable_and_comparator.example_1.Employee cannot be cast to java.lang.Comparable
        Employee[] empArray = {employee1, employee3, employee4, employee2};
        System.out.println("Before sorting (array): " + Arrays.toString(empArray));
        Arrays.sort(empArray);
        System.out.println("After sorting (array): " + Arrays.toString(empArray));

        System.out.println("\n============================================\n");

        // If Employee does not implement Comparable, a compilation error will be shown.
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(employee4, employee2, employee1, employee3));
        System.out.println("Before sorting (list): " + employeeList);
        Collections.sort(employeeList);
        System.out.println("After sorting (list): " + employeeList);
    }
}
