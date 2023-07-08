package com.ti.java.encapsulation;

class Person {
    public String name;
    private int age;

    public String getName(String name) {
        this.name = name;
        return name;
    }

    /*private void setName(String name) {
        this.name = name;
    }*/

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Main {
    private static String text;

    public static void main(String[] args) {
        text = "text";
        Person person = new Person();
        person.name = "Gilberto";
        person.setAge(34);

        System.out.println("Name: " + person.getName("Gil") + " Age: " + person.getAge());
    }

}
