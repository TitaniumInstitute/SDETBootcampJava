package com.ti.java;

import java.util.Scanner;

public class RelationalOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.println("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("num1 > num2 is " + (num1 > num2));
        System.out.println("num1 < num2 is " + (num1 < num2));
        System.out.println("num1 >= num2 is " + (num1 >= num2));
        System.out.println("num1 <= num2 is " + (num1 <= num2));
        System.out.println("num1 == num2 is " + (num1 == num2));
        System.out.println("num1 != num2 is " + (num1 != num2));
    }
}
