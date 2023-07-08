package com.ti.java.polymorphism.parametric;

public class Persona {
    private String name;
    private int age;

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void returnInformation() {
        System.out.println("My name is " + name + " and my age is " + age);
    }
}
