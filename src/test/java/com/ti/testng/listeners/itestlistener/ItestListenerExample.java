package com.ti.testng.listeners.itestlistener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListenerExample implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started -> " + result.getName());
        System.out.println("Time -> " + result.getStartMillis());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed was -> " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed -> " + result.getName());
    }

}
