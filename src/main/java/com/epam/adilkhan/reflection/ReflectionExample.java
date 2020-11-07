package com.epam.adilkhan.reflection;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // Three options for creating Class instance
        Class<?> employeeClass1 = Class.forName("com.epam.adilkhan.reflection.Employee");

        Class<Employee> employeeClass2 = Employee.class;

        Employee employee = new Employee();
        Class<? extends Employee> employeeClass3 = employee.getClass();

        // Note: `getDeclaredMethods()` includes all methods declared by the class itself, whereas `getMethods()`
        // returns only public methods, but also those inherited from a base class (here from `java.lang.Object`)
        Method[] methods = employeeClass1.getDeclaredMethods();
        for (Method method : methods) {
            // show only public methods
            if (Modifier.isPublic(method.getModifiers())) { // Modifier
                System.out.println("Method: " + method.getName());
            }
        }

        // Options for creating Employee instance

        // Three options for creating Class instance
        Employee employee1 = (Employee) employeeClass1.newInstance();
        System.out.println(employee1);

        Constructor<Employee> constructor1 = (Constructor<Employee>) employeeClass1.getConstructor();
        Employee employee2 = constructor1.newInstance();
        System.out.println(employee2);

        Constructor<Employee> constructor2 = (Constructor<Employee>) employeeClass1.getConstructor(int.class, String.class, String.class, double.class);
        Employee employee3 = constructor2.newInstance(1, "Meriya", "IT", 45_000.7);
        System.out.println(employee3);

        Method setSalaryMethod = employeeClass1.getMethod("setSalary", double.class);
        setSalaryMethod.invoke(employee3, 88_549.88);
        System.out.println(employee3);

        Field salaryField = employeeClass1.getDeclaredField("salary");
        salaryField.setAccessible(true);
        double employee3Salary = (double) salaryField.get(employee3);
        System.out.println("Employee 3 Salary: " + employee3Salary);

        salaryField.set(employee3, 1000_500.90);
        System.out.println("Employee 3 Salary: " + employee3.getSalary());
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private void changeDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}