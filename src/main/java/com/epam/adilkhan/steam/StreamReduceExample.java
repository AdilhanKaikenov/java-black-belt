package com.epam.adilkhan.steam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);

        // reduce() method returns Optional
        int result1 = integerList.stream().reduce((accumulator, element) -> accumulator * element).get();
        // 1, 2, 3, 4, 5, 6
        // accumulator = 1
        // element = 2, 3, 4, 5, 6

        System.out.println(result1);

        int result2 = integerList.stream().reduce(10, (accumulator, element) -> accumulator * element);
        // 1, 2, 3, 4, 5, 6
        // accumulator = 10
        // element = 1, 2, 3, 4, 5, 6

        System.out.println(result2);

        // The Optional is a container for a value. The Optional class can contain an object or it can contain null.
        List<Integer> list = Collections.emptyList();
        Optional<Integer> optional = list.stream().reduce((accumulator, element) -> accumulator * element);

        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Not present!");
        }


    }
}
