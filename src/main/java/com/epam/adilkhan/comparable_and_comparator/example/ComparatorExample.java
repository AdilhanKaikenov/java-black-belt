package com.epam.adilkhan.comparable_and_comparator.example;

import com.epam.adilkhan.comparable_and_comparator.example.comparators.SalaryComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Sergey", "Petrov", 100_000);
        Employee employee3 = new Employee(3, "Zaur", "Tlegulov", 50_000);
        Employee employee4 = new Employee(4, "Sergey", "Sidorov", 400_000);
        Employee employee2 = new Employee(2, "Mariya", "Tlegulova", 250_000);

        // Employees are sorted in a natural order by first and last name, but if at some point it is necessary to sort
        // employees by ID or salary, then we cannot constantly change the compareTo (Employee anotherEmployee) method.
        // In this case, a comparator can be created and used as a second parameter and the sorting rules will be rewritten.
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(employee4, employee2, employee1, employee3));
        System.out.println("Before sorting (list): " + employeeList);
        Collections.sort(employeeList, new SalaryComparator());
        System.out.println("After sorting (list): " + employeeList);
    }
}
