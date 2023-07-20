package com.ti.testng;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class AnnotationsExample {

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

    @AfterSuite(description = "todo se derrumbó")
    void afterSuite() {
        System.out.println("Esto se ejecuta DESPUÉS de la suite");
    }

    @Test(priority = 2, description = "")
    void testSz() {
        System.out.println("Este es un test para probar un método de suma");
    }

    @Test(enabled = false, description = "")
    void testSq() {
        System.out.println("Este es un test para probar un método de suma");
    }

    @Test(enabled = false)
    void testSa() {
        System.out.println("Este es un test para probar un método de suma");
    }

    @Test(enabled = false)
    void testSo() {
        System.out.println("Este es un test para probar un método de resta");
        Assert.assertTrue(false);
    }

    @Test(priority = 2, expectedExceptions = {IOException.class, ArithmeticException.class, Exception.class})
    void testExpectedException() throws Exception {
        System.out.println("Any Exception found!");
        throw new Exception();
    }

    @Test(priority = 10, invocationCount = 5)
    void testInvocationCount() {
        System.out.println("Este método se ejecuta");
    }

    @Test(priority = 3, timeOut = 500)
    void testAPITime() throws InterruptedException {
        Thread.sleep(1000);
        System.err.println("No se cumple el tiempo");
    }

    @Test(priority = 3, timeOut = 500)
    void testAPITimeB() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("Si se cumple el tiempo");
    }
}
