package com.epam.adilkhan.work_with_files.io;

import java.io.*;

public class BufferedCopyExample {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("text1.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("text2.txt"))) {

//            int character;
//            while ((character = bufferedReader.read()) != -1) {
//                bufferedWriter.write(((char) character));
//            }

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
