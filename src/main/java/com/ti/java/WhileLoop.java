package com.ti.java;

public class WhileLoop {
    public static void main(String[] args) {
        /*int i = 1;

        while (i<6){
            System.out.println("Hi number: " + i);
            i++;
        }*/

        /*int x=1;
        int sum = 0;

        while (x<=10){
            //sum = sum + x;
            sum += x;
            x++;
        }
        System.out.println("Summation: " + sum);*/

        int weeks = 3;
        int days = 7;
        int i = 1;

        while (i <= weeks) {
            System.out.println("Week: " + i);

            for (int j = 1; j <= days; j++) {
                System.out.println("    Days: " + j);
            }

            ++i;
        }
    }
}
