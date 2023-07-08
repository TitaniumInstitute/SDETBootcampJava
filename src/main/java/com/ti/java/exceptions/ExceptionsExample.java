package com.ti.java.exceptions;

public class ExceptionsExample {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

        int[] arr = new int[4];

        int i = arr[4];

        //System.out.println(a/b);
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            //e.printStackTrace();
            System.out.println(b / a);
            //System.err.println(e);
            //System.err.println("Not able division by Zero");
        } catch (ArrayIndexOutOfBoundsException ae) {
            ae.printStackTrace();
        } finally {
            System.out.println("Value of a is: " + a + " and b is: " + b);
        }
    }
}
