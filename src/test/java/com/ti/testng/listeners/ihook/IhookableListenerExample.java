package com.ti.testng.listeners.ihook;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class IhookableListenerExample implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        Object[] parameterValues = callBack.getParameters();
        /*if (parameterValues[0].equals("GET")) {
            System.out.println("POST");
        } else {
            callBack.runTestMethod(testResult);
        }*/
    }
}
