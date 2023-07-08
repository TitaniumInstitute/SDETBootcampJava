package com.ti.java.interfaces;

import java.util.Random;

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle[] vehicles;
        Random random = new Random();

        vehicles = new Vehicle[6];
        vehicles[0] = new Moto();
        vehicles[1] = new Car();
        vehicles[2] = new Moto();
        vehicles[3] = new Moto();
        vehicles[4] = new Car();
        vehicles[5] = new Moto();

        int upperbound = 200;

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.accelerate(random.nextInt(upperbound)));
            System.out.println(vehicle.stop(random.nextInt(upperbound)));
        }

        //Si cuando frenas, la velocidad es negativa, convertirla automaticamente a 0
    }
}
