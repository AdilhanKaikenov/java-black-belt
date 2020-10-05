package com.epam.adilkhan.nested_classes.static_nested_class;

public class Car {
    private String color;
    private int countDoor;
    private Engine engine;
    private static int version;

    public Car(String color, int countDoor, Engine engine) {
        this.color = color;
        this.countDoor = countDoor;
        this.engine = engine;
    }

    public void printEngineFields() {
        System.out.println(Engine.countOfObjects);

        Engine engine = new Engine(200);
        System.out.println(engine.horsePower);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", countDoor=" + countDoor +
                ", engine=" + engine +
                '}';
    }

    public static class Engine {
        private int horsePower;
        private static int countOfObjects;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
            countOfObjects++;
            System.out.println(version);
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {

        Car.Engine engine = new Car.Engine(300);
        System.out.println(engine);

        Car car = new Car("red", 2, engine);
        System.out.println(car);
    }
}