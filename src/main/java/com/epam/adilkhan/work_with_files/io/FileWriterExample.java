package com.epam.adilkhan.work_with_files.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        String text = "По несчастью или к счастью, Истина проста: \n" +
                "Никогда не возвращайся В прежние места. \n" +
                "Даже если пепелище Выглядит вполне, \n" +
                "Не найти того, что ищем, Ни тебе, ни мне. \n";

        try (FileWriter fileWriter = new FileWriter("text1.txt", false)) { // append is false
            fileWriter.write(text);

            fileWriter.append("\nCтих Геннадия Шпаликова");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
