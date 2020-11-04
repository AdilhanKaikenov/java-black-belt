package com.epam.adilkhan.work_with_files.serialization_example.programmer1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample_02 {
    public static void main(String[] args) {
        Employee employee = new Employee("Mariya", "IT", 25, 500); // Must implement Serializable
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees2.bin"))) {
            outputStream.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
