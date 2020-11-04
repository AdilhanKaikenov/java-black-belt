package com.epam.adilkhan.work_with_files;

import java.io.FileReader;

public class FileReaderExample {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("text1.txt")) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print(((char) character));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
