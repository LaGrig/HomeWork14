package com.mobile.test;

import org.testng.annotations.Test;

public class InetShopTest {

    @Test
    public void login() {
        System.out.println("InetShopTest::login @ " + Thread.currentThread().getName());
    }

    @Test
    public  void signup() {
        System.out.println("InetShopTest::signup @ " + Thread.currentThread().getName());
    }

    @Test
    public  void functionality0() {
        System.out.println("InetShopTest::functionality0 @ " + Thread.currentThread().getName());
    }

    @Test
    public  void functionality1() {
        System.out.println("InetShopTest::functionality1 @ " + Thread.currentThread().getName());
    }

    @Test
    public  void functionality2() {
        System.out.println("InetShopTest::functionality2 @ " + Thread.currentThread().getName());
    }

}
