package com.ti.java.generics;

public class GenericExample {
    public static void main(String[] args) {
        PrinterGeneric<String> pg = new PrinterGeneric<>();
        pg.print("My T is  String");

        PrinterGeneric<Double> pd = new PrinterGeneric<>();
        pg.print(100.00);
    }
}
