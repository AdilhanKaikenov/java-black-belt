package com.epam.adilkhan.regex;

public class RegexExample_07 {

    private static void employeeInfo(Employee employee) {
        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n",
                employee.id, employee.name, employee.surname, employee.salary * (1 + employee.bonusPct));
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Oleg", "Petrov", 50_000, 0.15);
        Employee employee2 = new Employee(12, "Mariya", "Sidorova", 60_000, 0.08);
        Employee employee3 = new Employee(123, "Victor", "Afonasiev", 90_000, 0.12);

        employeeInfo(employee1);
        employeeInfo(employee2);
        employeeInfo(employee3);

        System.out.println("\n===============================================================\n");

        String formated = String.format("Id: %03d \t Name: %-12s \t Surname: %-12s \t Salary: %,.1f \n",
                1, "Oleg", "Petrov", 50_000 * (1 + 0.15));
        System.out.println(formated);
    }
}

class Employee {

    int id;
    String name;
    String surname;
    int salary;
    double bonusPct;

    public Employee(int id, String name, String surname, int salary, double bonusPct) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bonusPct = bonusPct;
    }
}
