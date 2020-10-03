package com.epam.adilkhan.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class WildcardsExample {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal());

        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet());
        pets.add(new Pet());

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        System.out.println("\n==========iterateAnimals==========\n");

        iterateAnimals(animals);
        iterateAnimals(pets);
        iterateAnimals(cats);
        iterateAnimals(dogs);

        System.out.println("\n==========iterateCatAnimals==========\n");

        iterateCatAnimals(animals);
        iterateCatAnimals(pets);
        iterateCatAnimals(cats);

//        iterateCatAnimals(dogs); // compile error: Collection<? super Cat> animals
    }

    // The method accepts as input a collection of objects of the Animal class or objects of any class inheriting from Animal (? Extends Animal).
    public static void iterateAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println("Animal class: " + animal.getClass());
        }
    }

    // The construction <? super Cat> tells the compiler that the iterateCatAnimals () method can accept a collection of Cat objects or
    // any other Cat ancestor class as input.
    public static void iterateCatAnimals(List<? super Cat> animals) {
        for (Object animal : animals) {
            System.out.println("Animal class: " + animal.getClass());
        }
    }
}

class Animal {
    public void feed() {
        System.out.println("Animal.feed()");
    }
}

class Pet extends Animal {
    public void call() {
        System.out.println("Pet.call()");
    }
}

class Cat extends Pet {
    public void meow() {
        System.out.println("Cat.meow()");
    }
}

class Dog extends Pet {
    public void bark() {
        System.out.println("Dog.bark()");
    }
}