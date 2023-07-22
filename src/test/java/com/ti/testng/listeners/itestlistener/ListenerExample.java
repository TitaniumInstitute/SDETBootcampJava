package com.ti.testng.listeners.itestlistener;

import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(ItestListenerExample.class)
public class ListenerExample {

    @Test
    void testA() {
        System.out.println("testA");
        Assert.fail();
    }

    @Test
    void testB() {
        System.out.println("testB");
        Assert.assertTrue(true);
    }

    @Test
    void testC() {
        System.out.println("testC");
        Assert.assertEquals("a", "a");
    }

    @Test
    void testD() {
        System.out.println("testD");
        Assert.assertFalse("a".equals("a"));
    }
}
