package com.ti.java.interfaces;

public class Moto implements Vehicle {
    int speed;

    @Override
    public String stop(int quantity) {
        speed -= quantity;
        return "The moto has stopped and is going " + speed + "km/h";
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
        System.out.println("I'm a Ducati!");
    }
}
