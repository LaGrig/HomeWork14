package com.mobile.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import cucumber.api.java.es.Pero;

import java.util.Arrays;

public class Person {

    @JsonProperty
    String name;

    @JsonProperty
    int age;

    @JsonProperty
    String[] hobbies;

    @JsonProperty
    Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", address=" + address +
                '}';
    }
}
