package com.ti.testng.listeners.ihook;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(IhookableListenerExample.class)
public class ListenerIHook {
    @Test(dataProvider = "parametersToBeSent")
    void IhookListenerExample(String param) {
        System.out.println("Test method to be called with the following parameter is " + param);
    }

    @DataProvider
    Object[][] parametersToBeSent() {
        return new Object[][]{
                {"GET"},
                {"POST"},
                {"DELETE"}
        };
    }

}
