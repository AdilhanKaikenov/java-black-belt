package com.epam.adilkhan.comparable_and_comparator.example.comparators;

import com.epam.adilkhan.comparable_and_comparator.example.Employee;

import java.util.Comparator;

public class IdEmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employeeOne, Employee employeeTwo) {
        return Integer.compare(employeeOne.getId(), employeeTwo.getId());
    }
}
