package com.epam.adilkhan.steam;

import java.util.ArrayList;
import java.util.List;

// Parallel stream is the ability to use multiple processor cores when performing any operations on the stream.
// Parallel stream is more suitable for aggregated operations and not at all suitable where ordering is important (the result will be incorrect)
public class StreamParallelStream {
    public static void main(String[] args) {

        List<Double> numbers = new ArrayList<>();
        numbers.add(10.0);
        numbers.add(5.0);
        numbers.add(1.0);
        numbers.add(0.25);

        Double sumResult1 = numbers.stream().reduce((accumulator, number) -> accumulator + number).get();
        Double sumResult2 = numbers.parallelStream().reduce((accumulator, number) -> accumulator + number).get();
        System.out.println("Sequential sum result: " + sumResult1);
        System.out.println("Parallel sum result: " + sumResult2);

        System.out.println("\n=============================================================================\n");

        Double divisionResult1 = numbers.stream().reduce((accumulator, number) -> accumulator / number).get();
        Double divisionResult2 = numbers.parallelStream().reduce((accumulator, number) -> accumulator / number).get();
        System.out.println("Sequential division result: " + divisionResult1);
        System.out.println("Parallel division result: " + divisionResult2); // incorrect result
    }
}
