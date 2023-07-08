package com.ti.java.generics;

public class TestGeneric {
    public static void main(String[] args) {
        genericDisplay(11);
        genericDisplay("SDET Bootcamp");
        genericDisplay(1.0f);
    }

    static <T> void genericDisplay(T type) {
        System.out.println(type.getClass().getName() + "=" + type);
    }

    /*static void genericDisplay(String s){
        System.out.println(s);
    }

    static void genericDisplay(int s){
        System.out.println(s);
    }*/

}
