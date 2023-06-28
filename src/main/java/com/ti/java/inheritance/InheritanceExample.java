package com.ti.java.inheritance;

public class InheritanceExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
        animal.walk();
        animal.drinkWater();

        Cat garfield = new Cat();
        garfield.eat();
        garfield.walk();
        garfield.hateMondays();

        Dog scooby = new Dog();
        scooby.loveDogChau();
        scooby.eat();

        Bird tweety = new Bird();
        tweety.fly();
        tweety.walk();

    }
}
