package com.epam.adilkhan.nested_classes.inner_class;

public class Car {
    private String color;
    private int countDoor;
    private Engine engine;
    private static int version;

    public Car(String color, int countDoor) {
        this.color = color;
        this.countDoor = countDoor;
    }

    public Car(String color, int countDoor, int horsePower) {
        this.color = color;
        this.countDoor = countDoor;
        this.engine = this.new Engine(horsePower);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", countDoor=" + countDoor +
                ", engine=" + engine +
                '}';
    }

    public class Engine {
        private int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
            System.out.println(countDoor);
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
        Car car = new Car("red", 2);
        System.out.println(car);

        Car.Engine engine = car.new Engine(200);
        car.setEngine(engine);
        System.out.println(car);

        System.out.println("\n================================\n");

        Car.Engine engineTwo = new Car("blue", 4).new Engine(200);
        System.out.println(engineTwo);
    }
}