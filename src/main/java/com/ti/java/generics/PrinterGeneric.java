package com.ti.java.generics;

public class PrinterGeneric<T> {
    //T thingToPrint;

    public <T> void print(T thingToPrint) {
        System.out.println(thingToPrint);
    }
}
