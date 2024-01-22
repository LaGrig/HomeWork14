package com.mobile.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class OrderTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("OrderTest::beforeSuite" + Thread.currentThread().getName());
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("OrderTest::afterSuite" + Thread.currentThread().getName());
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("OrderTest::beforeClass" + Thread.currentThread().getName());
    }

    @AfterClass
    public void afterClass() {
        System.out.println("OrderTest::afterClass" + Thread.currentThread().getName());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("OrderTest::beforeMethod" + Thread.currentThread().getName());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("OrderTest::afterMethod" + Thread.currentThread().getName());
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("OrderTest::beforeTest" + Thread.currentThread().getName());
    }

    @AfterTest
    public void afterTest() {
        System.out.println("OrderTest::afterTest" + Thread.currentThread().getName());
    }

}
