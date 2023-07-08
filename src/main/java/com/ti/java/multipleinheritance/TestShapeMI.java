package com.ti.java.multipleinheritance;

public class TestShapeMI {
    public static void main(String[] args) {
        Shapes shapes = new Shapes();
        shapes.addShape(new Circle(3.456));
        shapes.addShape(new Triangle(3.456, 2.17));
        shapes.addShape(new Square(2.11));

        shapes.list();
    }
}
