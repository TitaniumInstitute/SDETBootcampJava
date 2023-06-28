package com.ti.java.inheritance;

public class Animal {
    public String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("I can eat!!");
    }

    public void walk() {
        System.out.println("Walking!!");
    }

    void drinkWater() {
        System.out.println("I'm drinking water!");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
    }
}

