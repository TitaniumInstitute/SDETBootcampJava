package com.ti.testng.listeners.itestlistener;

import org.testng.IExecutionListener;

public class ItestExecutionExample implements IExecutionListener {

    public void onExecutionStart() {
        long startTime = System.currentTimeMillis();
        System.out.println("All suite have started at " + startTime);
    }

    public void onExecutionFinish() {
        long endTime = System.currentTimeMillis();
        System.out.println("All suite have finished at " + endTime);
    }
}
