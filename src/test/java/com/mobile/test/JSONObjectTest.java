package com.mobile.test;

import org.json.JSONArray;  //Should be here for commented methods (methods from lesson)
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSONObjectTest {

    @Test
    public void createJsonHomework() {
        JSONObject json3 = new JSONObject();
        json3.put("brand", "Samsung");
        json3.put("model", "s24");
        json3.put("model year", 2024);
        json3.put("OS", "Android");
        Assert.assertEquals(json3.get("brand"), "Samsung");
        Assert.assertEquals(json3.get("model"), "s24");
        Assert.assertEquals(json3.get("model year"), 2024);
    }
//
//    private final String Grigoriy = "{\n" +
//            " \"name\": \"Grigoy Lakiza\",\n" +
//            " \"age\": 41,\n" +
//            " \"address\": {\n" +
//            "\"street\": \"Marselskaya Street\",\n" +
//            "\"city\": \"Odesa\",\n" +
//            "\"country\": \"Ukraine\"\n" +
//            " },\n" +
//            " \"hobbies\": [\"gaming\", \"music\", \"traveling\"]\n" +
//            "}\n";
//
//    @Test
//    public void parseJson() {
//        JSONObject json = new JSONObject(Grigoriy);
//        System.out.println(json);
//        System.out.println(json.get("address"));
//        Assert.assertEquals(json.getJSONObject("address").get("street"), "Marselskaya Street");
//        Assert.assertEquals(json.getJSONArray("hobbies").get(2), "traveling");
//        json.put("age", 40);
//        System.out.println(json);
//    }
//
//    @Test
//    public void createJson() {
//        JSONObject json2 = new JSONObject();
//        json2.put("name:", "Greg");
//        json2.put("age:", 30);
//        json2.put("address", new JSONObject()
//                .put("street", "Zabolotnogo street")
//                .put("height", "182cm")
//        );
//        json2.put("hobbies:", new JSONArray()
//                .put("gambling")
//                .put("driving")
//                .put("drinking")
//        );
//        System.out.println(json2);
//    }
}
