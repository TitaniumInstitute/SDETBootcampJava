package com.ti.java.multipleinheritance;

public class Triangle extends Shape implements Sides {

    private double base;
    private double high;

    public Triangle(double base, double high) {
        this.base = base;
        this.high = high;
    }

    @Override
    public double calculeteArea() {
        return (base * high) / 2;
    }

    @Override
    public String shapeName() {
        return "Triangle";
    }

    @Override
    public int numSides() {
        return 3;
    }
}
