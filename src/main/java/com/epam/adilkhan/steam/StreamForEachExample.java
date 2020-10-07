package com.epam.adilkhan.steam;

import java.util.Arrays;

public class StreamForEachExample {
    public static void main(String[] args) {
        int[] array = {5, 6, 1, 3, 4, 9};

        // Utils::method - method reference
        Arrays.stream(array).forEach(Utils::method);


    }
}

class Utils {
    public static void method(int number) {
        number = number + 10;
        System.out.println("Element = " + number);
    }

    public static void method1(int number) {
        number = number + 10;
        System.out.println("Element = " + number);
    }
}