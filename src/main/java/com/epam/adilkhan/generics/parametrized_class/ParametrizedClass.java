package com.epam.adilkhan.generics.parametrized_class;

import java.util.ArrayList;
import java.util.List;

public class ParametrizedClass {
    public static void main(String[] args) {
        Info<String> info1 = new Info<>("Hello!");
        System.out.println(info1);
        String value1 = info1.getValue();

        Info<Integer> info2 = new Info<>(20);
        System.out.println(info2);
        Integer value2 = info2.getValue();

        List<String> list = new ArrayList<>();
    }
}

// T - type placeholder
class Info<T> {

//    Cannot be static as static means common at the class level for all objects.
//    private static T value;
    private T value;

    public Info(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Info {[value=" + this.value + "]}";
    }
}
