package com.epam.adilkhan.work_with_files.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathAndFilesExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("test_file_1.txt");

//        Files.createFile(path);
//        String dialog = "- Privet!\n- Kak dela?\n- Xorosho!\n- Kak tvoy dela?\n- Toshe Xorosho!";
//        Files.write(path, dialog.getBytes());

        List<String> allLines = Files.readAllLines(path);
        for (String line : allLines) {
            System.out.println(line);
        }

    }
}
