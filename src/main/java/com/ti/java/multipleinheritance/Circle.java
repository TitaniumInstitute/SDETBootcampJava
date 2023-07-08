package com.ti.java.multipleinheritance;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculeteArea() {
        return Math.PI * radius;
    }

    @Override
    public String shapeName() {
        return "Circle";
    }
}
