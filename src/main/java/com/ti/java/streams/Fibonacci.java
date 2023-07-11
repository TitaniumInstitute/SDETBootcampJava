package com.ti.java.streams;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Fibonacci Series");

        int num1 = 0, num2 = 1, limit = 15;

        for (int i = 0; i < limit; i++) {
            System.out.println(num1 + " ");
            int sum = num1 + num2;

            num1 = num2;
            num2 = sum;
        }
    }
}
