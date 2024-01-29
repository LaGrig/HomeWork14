package com.mobile.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mobile.test.dto.Address;
import com.mobile.test.dto.Person;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JacksonTest {
    private final String Grigoriy = "{\n" +
            " \"name\": \"Grigoy Lakiza\",\n" +
            " \"age\": 41,\n" +
            " \"address\": {\n" +
            "\"street\": \"Marselskaya Street\",\n" +
            "\"city\": \"Odesa\",\n" +
            "\"country\": \"Ukraine\"\n" +
            " },\n" +
            " \"hobbies\": [\"gaming\", \"music\", \"traveling\"]\n" +
            "}\n";

    @Test
    public void createJson() throws JsonProcessingException {
        var person = new Person();
        person.setAge(40);
        person.setName("Greg");
        person.setHobbies(new String[]{"Black jack", "Cigars", "Cars"});
        var address = new Address();
        address.setCountry("Brasil");
        address.setCity("SomeCity");
        address.setStreet("SomeStreet");
        person.setAddress(address);
        var mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(person);
        Assert.assertEquals(person.getName(), "Greg");
        Assert.assertEquals(person.getAge(), 40);
        System.out.println(json);
    }

    @Test
    public void createXML() throws JsonProcessingException {
        var person = new Person();
        person.setAge(40);
        person.setName("Greg");
        person.setHobbies(new String[]{"Black jack", "Cigars", "Cars"});
        var address = new Address();
        address.setCountry("Brasil");
        address.setCity("SomeCity");
        address.setStreet("SomeStreet");
        person.setAddress(address);
        var mapper = new XmlMapper();
        Assert.assertEquals(person.getName(), "Greg");
        Assert.assertEquals(person.getAge(), 40);
        System.out.println(mapper.writeValueAsString(person));
    }

    @Test
    public void parseJson() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        var person = mapper.readValue(Grigoriy, Person.class);
        var address = person.getAddress();
        System.out.println(person);
        System.out.println(address);

    }
}
