package com.epam.adilkhan.work_with_files.serialization_example.programmer1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample_01 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Elena");
        employees.add("Oleg");
        employees.add("Viktor");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees1.bin"))) {
            outputStream.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
