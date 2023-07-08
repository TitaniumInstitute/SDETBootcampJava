package com.ti.java.polymorphism.inheritance;

public class Airplane extends Vehicle {
    public void fuelMix() {
        System.out.println("Fuel mixed!");
    }

    public void injectFuel() {
        System.out.println("Fuel Injected!");
    }

    @Override
    public void turnOn() {
        fuelMix();
        injectFuel();
    }
}
