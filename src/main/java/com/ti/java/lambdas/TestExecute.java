package com.ti.java.lambdas;

import java.util.ArrayList;

public class TestExecute {
    public static void main(String[] args) {
        //Cat cat = new Cat();
        //cat.print();
        /*Printable lambdaPrint = (n) -> "Meow, my name is " + n;

        System.out.println(lambdaPrint.print("Kitty"));*/

        //printThing( lambdaPrint);

        Calculator calculator = ((a, b) -> {
            double result = a + b;
            System.out.println(result);
        });

        Calculator calculatorSub = ((a, b) -> {
            double result = a - b;
            System.out.println(result);
        });

        Calculator calculator1 = (a, x) -> {
            double result = a * x;
            System.out.println(result);
        };

//        calculator.operation(2,3);
//        calculatorSub.operation(20,5);
//        calculator1.operation(3,9);

        ArrayList<Integer> arrNum = new ArrayList<>();
        arrNum.add(1);
        arrNum.add(2);
        arrNum.add(3);
        arrNum.add(4);
        arrNum.add(5);

        for (Integer num : arrNum) {
        }

        arrNum.forEach(n -> System.out.println(n + 1));
        //arrNum.forEach(System.out::println);


    }

    static void sum(Calculator calculator, double a, double b) {
        calculator.operation(a, b);
    }

    static void printThing(Printable printable) {
        printable.print("name");
    }
}
