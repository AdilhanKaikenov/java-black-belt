package com.epam.adilkhan.work_with_files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryCopyExample {
    public static void main(String[] args) {
        // BufferedInputStream and BufferedOutputStream can also be used
        try (FileInputStream inputStream = new FileInputStream("./src/main/java/com/epam/adilkhan/work_with_files/etc/java_picture.jpg");
             FileOutputStream outputStream = new FileOutputStream("copied_java_pictire.jpg")) {

            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
