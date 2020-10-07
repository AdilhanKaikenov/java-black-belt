package com.epam.adilkhan.steam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello!");
        list.add("How are you?");
        list.add("Ok");
        list.add("Goodbye!");

//      Stream methods do not change the collection itself or the array from which the stream was created
        List<Integer> newList = list.stream()
                .map(element -> element.length())
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(newList);

        System.out.println("\n=====================================\n");

        int[] array = {5, 6, 1, 3, 4, 9};
        array = Arrays.stream(array).map(element -> {
            if (element % 3 == 0) {
                element = element / 3;
            }

            return element;
        }).toArray();

        System.out.println(Arrays.toString(array));
    }
}
