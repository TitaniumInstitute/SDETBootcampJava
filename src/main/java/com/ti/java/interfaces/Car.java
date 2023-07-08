package com.ti.java.interfaces;

public class Car implements Vehicle {
    int speed = 0;

    @Override
    public String stop(int quantity) {
        //speed = speed - quantity;
        speed -= quantity;
        return "The car has stopped ans is going " + speed + "km/h";
    }

    @Override
    public String accelerate(int quantity) {
        String speeding = "";
        //speed= speed + quantity;
        speed += quantity;
        if (speed > MAXIMUM_SPEED)
            speeding = "Speeding";
        speeding += " The car has accelerated ans is going " + speed + "km/h";
        return speeding;
    }

    @Override
    public void vehicleName(String name) {
        System.out.println("I'm a Mustang!");
    }

    public void wheelsNumber() {
        System.out.println("4 Wheels!");
    }
}
