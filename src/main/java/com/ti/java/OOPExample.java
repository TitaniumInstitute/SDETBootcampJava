package com.ti.java;

public class OOPExample {
    public static void main(String[] args) {

        Employee.setEmployeeName("Luis");
        Employee.setSalary(1000.0f);

        System.out.println(Employee.getEmployeeName() + " his/her salary is " + Employee.getSalary());

        Employee.setEmployeeName("Jimena");
        Employee.setSalary(2000.0f);

        System.out.println(Employee.getEmployeeName() + " his/her salary is " + Employee.getSalary());

        /*Car car = new Car(4);

    //
        System.out.println(car.getTireCount());*/
    }

    public class Car {

        public Car(int tireCount) {
            this.tireCount = tireCount;
        }

        public int tireCount;

        public int getTireCount() {
            return tireCount;
        }

        /*public void setTireCount(int tireCount) {
            this.tireCount = tireCount;
        }*/
    }

    class Employee {
        static String employeeName;
        static float salary;

        /*public static String getEmployeeName() {
            return employeeName;
        }

        public static void setEmployeeName(String employeeName) {
            Employee.employeeName = employeeName;
        }

        public static float getSalary() {
            return salary;
        }

        public static void setSalary(float salary) {
            Employee.salary = salary;
        }*/

        //Mutator
        //Método
        static void setEmployeeName(String name) {
            employeeName = name;
        }

        static void setSalary(float salaryEmployee) {
            salary = salaryEmployee;
        }

        //Accesor
        static float getSalary() {
            return salary;
        }

        static String getEmployeeName() {
            return employeeName;
        }
    }
}
