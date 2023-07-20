package com.ti.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    @BeforeMethod
    void beforeMethod() {
        System.out.println("Esto se ejecuta ANTES de cada MÉTODO de prueba en mi superclase");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("Esto se ejecuta DESPUÉS de cada MÉTODO de prueba en mi superclase");
    }

}
