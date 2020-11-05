package com.epam.adilkhan.work_with_files.io.serialization_example.programmer2;

import com.epam.adilkhan.work_with_files.io.serialization_example.programmer1.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationExample_02 {
    public static void main(String[] args) {
        Employee employee;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employees2.bin"))) {

            employee = (Employee) inputStream.readObject();
            System.out.println(employee);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
