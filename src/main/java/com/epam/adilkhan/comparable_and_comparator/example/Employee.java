package com.epam.adilkhan.comparable_and_comparator.example;

public class Employee implements Comparable<Employee> {

    private int id;
    private String firstname;
    private String lastname;
    private double salary;

    public Employee(int id, String firstname, String lastname, double salary) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee anotherEmployee) {
        int result = this.firstname.compareTo(anotherEmployee.firstname);
        if (result == 0) {
            result = this.lastname.compareTo(anotherEmployee.lastname);
        }

        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
