package com.ti.testng;

import org.testng.annotations.*;

public class AnnotationsExample extends BaseClass {

    @BeforeSuite
    void beforeSuite() {
        System.out.println("Esto se ejecuta ANTES de la suite");
    }

    @BeforeTest
    void beforeTes() {
        System.out.println("Esto se ejecuta ANTES de la primer prueba que encuentre");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Esto se ejecuta ANTES de las clases de prueba");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Esto se ejecuta ANTES de cada MÉTODO de prueba en mi clase");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("Esto se ejecuta DESPUÉS de cada MÉTODO de prueba en mi clase");
    }

    @AfterClass
    void AfterClass() {
        System.out.println("Esto se ejecuta DESPUÉS de las clases de prueba");
    }

    @AfterTest
    void afterTes() {
        System.out.println("Esto se ejecuta DESPUÉS de la primer prueba que encuentre");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("Esto se ejecuta DESPUÉS de la suite");
    }

    @Test
    void testSz() {
        System.out.println("Este es un test para probar un método de suma");
    }

    @Test
    void testSq() {
        System.out.println("Este es un test para probar un método de suma");
    }

    @Test
    void testSa() {
        System.out.println("Este es un test para probar un método de suma");
    }

    @Test
    void testSo() {
        System.out.println("Este es un test para probar un método de resta");
    }
}
