package com.ti.testng.listeners.itestlistener;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//@Listeners(ItestListenerExample.class)
public class ListenerExample {

    @Test(enabled = false)
    void testA() {
        System.out.println("testA");
        Assert.fail();
    }

    @Test(enabled = false)
    void testB() {
        System.out.println("testB");
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    void testC() {
        System.out.println("testC");
        Assert.assertEquals("a", "a");
    }

    @Test(enabled = false)
    void testD() {
        System.out.println("testD");
        Assert.assertFalse("a".equals("a"));
    }

    @Test(dataProvider = "parametersToBeSent")
    void IhookListenerExample(String param) {
        System.out.println("Test method to be called with the following parameter is " + param);
    }

    @DataProvider
    Object[][] parametersToBeSent() {
        return new Object[][]{
                {"param1"},
                {"param2"},
                {"param3"}
        };
    }
}
