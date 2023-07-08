package com.ti.java.encapsulation;

public class AreaTi {
    int lenght;
    int breadth;

    public AreaTi(int lenght, int breadth) {
        this.lenght = lenght;
        this.breadth = breadth;
    }

    public void getArea() {
        int area = lenght * breadth;
        System.out.println("Area is: " + area);
    }
}
