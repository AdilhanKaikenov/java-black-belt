package com.epam.adilkhan.generics.subtyping;

public class SubtypingExample {
    public static void main(String[] args) {

        Info<Number> number = new Info<>(1);
        Info<Integer> integer = new Info<>(1);
        Info<Double> doubleInfo = new Info<>(3.14);

    }
}

class Info<T extends Number> {

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