package com.epam.adilkhan.lambda_expressions;

public class Car {
    private String model;
    private String colour;
    private double engine;

    public Car(String model, String colour, double engine) {
        this.model = model;
        this.colour = colour;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", engine=" + engine +
                '}';
    }
}