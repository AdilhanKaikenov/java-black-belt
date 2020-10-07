package com.epam.adilkhan.steam;

import java.util.Arrays;

public class StreamSortedExample {
    public static void main(String[] args) {
        int[] array = {90, 2, 34, 53, 23, 34, 54};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));
    }
}
