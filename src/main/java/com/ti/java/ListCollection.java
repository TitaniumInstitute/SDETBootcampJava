package com.ti.java;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Porshe");
        cars.add("Mercedez");
        cars.add("Mercedez");
        cars.add("Porshe");

        System.out.println(cars.size());
        System.out.println(cars);

        cars.set(4, "Jaguar");
        System.out.println(cars);

        int index = cars.indexOf("Audi");
        System.out.println("The first occurrence of BMW is at index " + index);

        int lastIndex = cars.lastIndexOf("Porshe");
        System.out.println("The last occurrence of Porshe is at index " + lastIndex);

        System.out.println(cars.get((cars.size() / 2) - 2));

        /*for (String car:cars) {
            System.out.println("The car is: " + car);
        }*/

        for (int i = 0; i < cars.size(); i++) { // size -1
            System.out.println("The car with normal for is: " + cars.get(i));
        }

    }
}
