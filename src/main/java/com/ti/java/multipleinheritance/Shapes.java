package com.ti.java.multipleinheritance;

import java.util.LinkedList;

public class Shapes {
    private LinkedList<Shape> shapeLinkedList = new LinkedList<>();

    public void addShape(Shape shape) {
        shapeLinkedList.add(shape);
    }

    public void list() {
        for (Shape shape : shapeLinkedList) {
            System.out.println("Shape name is: " + shape.shapeName());

            if (shape instanceof Sides) {
                Sides s = (Sides) shape;
                System.out.println("Sides numb is: " + s.numSides());
            }
        }
    }
}
