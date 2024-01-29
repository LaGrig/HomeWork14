package com.mobile.test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.test.dto.Activity;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FakeRestApiTest {

    final String apiUrl = "https://fakerestapi.azurewebsites.net/api/v1";
    OkHttpClient client = new OkHttpClient.Builder().build();

    @Test
    public void getAactivities() {
        final String endpointName = "/Activities";
        String url = apiUrl + endpointName;

        Request request = new Request.Builder()
                .url(url)
                .header("accept", "text/plain; v=1.0")
                .build();
        try (Response response = client.newCall(request).execute()) {
            int code = response.code();
            Assert.assertEquals(code, 200, "Response code must be 200, but we got " + code + "instead.");
            var mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Activity[] activities = mapper.readValue(response.body().string(), Activity[].class);
            Assert.assertEquals(activities.length, 30);
            Assert.assertEquals(activities[10].getId(), 11);
            Assert.assertEquals(activities[10].getTitle(), "Activity 11");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getSingleAactivity() {
        final String endpointName = "/Activities/11";
        String url = apiUrl + endpointName;

        Request request = new Request.Builder()
                .url(url)
                .header("accept", "text/plain; v=1.0")
                .build();
        try (Response response = client.newCall(request).execute()) {
            int code = response.code();
            Assert.assertEquals(code, 200, "Response code must be 200, but we got " + code + "instead.");
            var mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Activity[] activities = mapper.readValue(response.body().string(), Activity[].class);
            Assert.assertEquals(activities[0].getId(), 11);
            Assert.assertEquals(activities[0].getTitle(), "Activity 11");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deleteAactivities() {
        final String endpointName = "/Activities/13";
        String url = apiUrl + endpointName;

        Request request = new Request.Builder()
                .url(url)
                .method("DELETE", RequestBody.create("", MediaType.get("application/json")))
                .header("accept", "*/*")
                .build();
        try (Response response = client.newCall(request).execute()) {
            int code = response.code();
            Assert.assertEquals(code, 200, "Response code must be 200, but we got " + code + "instead.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}