package com.epam.adilkhan.steam;

import com.epam.adilkhan.lambda_expressions.Student;

import java.util.ArrayList;
import java.util.List;

// We use the flatMap() method when it is necessary to work not with the Stream elements themselves,
// but with the elements that will contain the Stream elements
public class StreamFlatMapExample {
    public static void main(String[] args) {
        Student student1 = new Student("Masha", 20, 2, 5.6);
        Student student2 = new Student("Petr", 23, 4, 7.9);
        Student student3 = new Student("Natasha", 21, 3, 9.2);
        Student student4 = new Student("Max", 19, 1, 6.7);
        Student student5 = new Student("Ira", 23, 4, 8.3);

        Faculty economics = new Faculty("Economics");
        Faculty math = new Faculty("Applied Mathematics");

        economics.addStudentToFaculty(student1);
        economics.addStudentToFaculty(student2);
        economics.addStudentToFaculty(student3);
        math.addStudentToFaculty(student4);
        math.addStudentToFaculty(student5);

        ArrayList<Faculty> faculties = new ArrayList<>();
        faculties.add(economics);
        faculties.add(math);

        faculties.stream()
                .flatMap(faculty -> faculty.getStudentList().stream())
                .forEach(System.out::println);


    }
}

class Faculty {
    String name;
    List<Student> studentList;

    public Faculty(String name) {
        this.name = name;
        this.studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudentToFaculty(Student student) {
        this.studentList.add(student);
    }
}
