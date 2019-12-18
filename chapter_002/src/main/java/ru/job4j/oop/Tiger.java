package ru.job4j.oop;

public class Tiger extends Predator {

    public Tiger() {
        super();
        System.out.println("class Tiger");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Predator predator = new Predator();
        Tiger tiger = new Tiger();
    }
}
