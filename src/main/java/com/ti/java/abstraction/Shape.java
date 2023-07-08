package com.ti.java.abstraction;

public abstract class Shape {
    public abstract double area();

    public abstract double perimeter();

    public String shapeName() {
        return "I'm a Shape";
    }
}
