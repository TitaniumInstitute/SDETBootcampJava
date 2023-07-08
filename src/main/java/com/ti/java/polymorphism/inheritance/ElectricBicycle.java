package com.ti.java.polymorphism.inheritance;

public class ElectricBicycle extends Vehicle {
    public void energizeEngine() {
        System.out.println("Engine energized!");
    }

    public void turnOnScreen() {
        System.out.println("Screen turner on!");
    }

    @Override
    public void turnOn() {
        energizeEngine();
        turnOnScreen();
    }
}
