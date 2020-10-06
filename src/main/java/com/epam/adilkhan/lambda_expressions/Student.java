package com.epam.adilkhan.lambda_expressions;

public class Student {
    private String name;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, int age, int course, double avgGrade) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
