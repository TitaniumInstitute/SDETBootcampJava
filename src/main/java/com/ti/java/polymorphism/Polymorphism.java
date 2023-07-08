package com.ti.java.polymorphism;

import com.ti.java.Browsers;
import com.ti.java.polymorphism.coercion.TriplerNumber;
import com.ti.java.polymorphism.inheritance.Airplane;
import com.ti.java.polymorphism.inheritance.ElectricBicycle;
import com.ti.java.polymorphism.inheritance.Vehicle;
import com.ti.java.polymorphism.overload.Robot;
import com.ti.java.polymorphism.parametric.Persona;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {
    public static void main(String[] args) {
        Robot droide = new Robot();
        droide.hello();
        droide.hello("R2-D2");
        droide.hello("C3-PO", 200);
        System.out.println(droide.selectBrowser(Browsers.SAFARI));

        TriplerNumber t = new TriplerNumber();
        double num1 = 2.5;
        int num2 = 5;

        System.out.println(t.tripler(num1));
        System.out.println(t.tripler(num2));
        System.out.println(t.tripler(1.5f));

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Luis", 32));
        personas.add(new Persona("Karen", 21));

        List<Robot> robots = new ArrayList<>();
        robots.add(new Robot());
        robots.add(new Robot());

        for (Persona persona : personas) {
            persona.returnInformation();
        }

        test(new Vehicle());
        test(new Airplane());
        test(new ElectricBicycle());


    }

    public static void test(Vehicle v) {
        v.turnOn();
    }
}
