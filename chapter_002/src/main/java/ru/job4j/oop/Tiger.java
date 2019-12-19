package ru.job4j.oop;

public class Tiger extends Predator {

    public Tiger(String name) {
        super(name);
        System.out.println("class Tiger");
    }

    public static void main(String[] args) {
        Animal animal = new Animal("animal");
        Predator predator = new Predator("predator");
        Tiger tiger = new Tiger("tiger");
    }
}
