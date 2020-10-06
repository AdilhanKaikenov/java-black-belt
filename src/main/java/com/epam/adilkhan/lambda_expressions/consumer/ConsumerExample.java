package com.epam.adilkhan.lambda_expressions.consumer;

import com.epam.adilkhan.lambda_expressions.Car;

import java.util.function.Consumer;

// Consumer, it is the opposite of Supplier, it has the accept() method that returns nothing, but accepts an object of type <T>
public class ConsumerExample {
    public static void main(String[] args) {
        Car car = new Car("Nissan", "Metalic", 1.6);

        changeCar(car, c -> {
            c.setColour("Red");
            c.setEngine(2.4);
            System.out.println("Upgraded: " + car);
        });
    }

    private static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }
}
