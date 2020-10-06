package com.epam.adilkhan.lambda_expressions.supplier;

import com.epam.adilkhan.lambda_expressions.Car;

import java.util.ArrayList;
import java.util.function.Supplier;

// Supplier, it has a method get() that returns an object of type <T>, the method without an argument.
public class SupplierExample {
    public static void main(String[] args) {
        ArrayList<Car> cars = createThreeCars(() -> new Car("Nissan", "Metalic", 1.6));
        cars.forEach(System.out::println);
    }

    private static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(carSupplier.get());
        }

        return cars;
    }
}
