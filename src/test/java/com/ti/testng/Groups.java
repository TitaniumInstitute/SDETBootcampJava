package com.ti.testng;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Groups {

    @BeforeGroups(groups = {"smoke", "defect"})
    void beforeGroups() {
        System.out.println("Running before group");
    }

    @BeforeGroups(groups = "backlog")
    void beforeBacklog() {
        System.out.println("Running before backlog");
    }

    @Test(groups = "backlog")
    void testBacklogA() {
        System.out.println("Testing item A in the backlog");
    }

    @Test(groups = "backlog")
    void testBacklogB() {
        System.out.println("Testing item A in the backlog");
    }

    @Test(groups = {"backlog", "smoke"})
    void testBacklogC() {
        System.out.println("Testing item A in the backlog");
    }

    @Test(groups = "defects")
    void testDefectA() {
        System.out.println("Testing item A in the backlog");
    }

    @Test(groups = "defects")
    void testDefectB() {
        System.out.println("Testing item A in the backlog");
    }

    @Test(groups = {"defects", "smoke"})
    void testDefectC() {
        System.out.println("Testing item A in the backlog");
    }
}
