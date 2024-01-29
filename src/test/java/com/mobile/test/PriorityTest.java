package com.mobile.test;

import org.testng.annotations.Test;

public class PriorityTest {

    @Test(groups = "orderGroup1", priority = 1)
    public void firstTest() {
        System.out.println("priorityTest::firstTest @ " + Thread.currentThread().getName());
    }

    @Test(groups = "orderGroup2", priority = 2, dependsOnGroups = "orderGroup1")
    public void secondTest() {
        System.out.println("priorityTest::secondTest @ " + Thread.currentThread().getName());
    }

    @Test(groups = "orderGroup3", priority = 3, dependsOnGroups = {"orderGroup1", "orderGroup2"})
    public void thirdTest() {
        System.out.println("priorityTest::thirdTest @ " + Thread.currentThread().getName());
    }

    @Test(priority = 4)
    public void fourthTest() {
        System.out.println("priorityTest::fourthTest @ " + Thread.currentThread().getName());
    }

    @Test(priority = 5)
    public void fifthTest() {
        System.out.println("priorityTest::fifthTest @ " + Thread.currentThread().getName());
    }
}
