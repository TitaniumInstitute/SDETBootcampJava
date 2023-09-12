package com.ti;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.HashMap;
import java.util.Map;

public class Retry implements IRetryAnalyzer {
    private byte count = 0;
    private static final byte maxTry = 3;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()){
            if (this.count < maxTry){
                System.out.println("Retry test " + iTestResult.getName() + " with status " + getResultsStatusName(
                        iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
                this.count ++;
                return true;
            }
        }
        return false;
    }

    private String getResultsStatusName(final int status){
        Map<Integer,String> testStatus = new HashMap<>();

        testStatus.put(1,"SUCCESS");
        testStatus.put(2,"FAILURE");
        testStatus.put(3, "SKIP");

        return testStatus.get(status);
    }
}
