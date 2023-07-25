package com.ti.testng.listeners.itestlistener;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class IhookableListenerExample implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        Object[] parameterValues = callBack.getParameters();
        if (parameterValues[0].equals("param3")) {
            System.out.println("Skipping the required parameter");
        } else {
            callBack.runTestMethod(testResult);
        }
    }
}
