package com.epam.adilkhan.steam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamMethodsExample {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(6, 7, 8, 9, 10);

        System.out.println("\n===================concat====================\n");

        Stream<Integer> concatStream = Stream.concat(stream1, stream2);
        concatStream.forEach(System.out::println);

        System.out.println("\n===================distinct====================\n");

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5));
        list.stream().distinct().forEach(System.out::println);

        System.out.println("\n=====================count===================\n");

        System.out.println("Count: " + list.stream().count());
        System.out.println("Distinct count: " + list.stream().distinct().count());

        System.out.println("\n====================peek====================\n");

        // The peek method allows you to see what happens at different stages in the chain of methods.
        System.out.println("Peek: " + list.stream().distinct().peek(System.out::println).count());

        System.out.println("\n===================findFirst=====================\n");

        Optional<Integer> first = list.stream().findFirst();
        System.out.println("First element: " + first.get());

        System.out.println("\n===================min=====================\n");

        Optional<Integer> min = list.stream().min(Integer::compareTo); // Comparator
        System.out.println("Min element: " + min.get());

        System.out.println("\n===================max=====================\n");

        Optional<Integer> max = list.stream().max(Integer::compareTo); // Comparator
        System.out.println("Max element: " + max.get());

        System.out.println("\n===================limit=====================\n");

        Stream<Integer> limit = list.stream().limit(2);
        limit.forEach(System.out::println);

        System.out.println("\n===================skip=====================\n");

        Stream<Integer> skip = list.stream().distinct().skip(2);
        skip.forEach(System.out::println);

        System.out.println("\n===================mapToInt=====================\n");

        Stream<Integer> mapToInt = list.stream()
                .mapToInt(value -> value)
                .boxed();
        // mapToInt ---> sum(), average(), min(), max()
        mapToInt.forEach(System.out::println);
    }
}
