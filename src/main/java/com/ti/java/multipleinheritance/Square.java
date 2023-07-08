package com.ti.java.multipleinheritance;

public class Square extends Shape implements Sides {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculeteArea() {
        return side * side;
    }

    @Override
    public String shapeName() {
        return "Square";
    }

    @Override
    public int numSides() {
        return 4;
    }
}
