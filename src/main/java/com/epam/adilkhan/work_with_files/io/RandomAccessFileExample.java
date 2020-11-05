package com.epam.adilkhan.work_with_files.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("text_file.txt", "rw")) {

            int a = file.read();
            System.out.println(((char) a));

            String line1 = file.readLine();
            System.out.println(line1);

            file.seek(101);
            String line2 = file.readLine();
            System.out.println(line2);

            long position = file.getFilePointer();
            System.out.println("Cursor position is " + position);

            file.seek(file.length() - 1);
            file.writeBytes("\n\n\t\t\t\t\t\tWilliam Butler Yeats");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
