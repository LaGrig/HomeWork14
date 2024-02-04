package com.mobile.test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.test.dto.Activity;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
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
    public void getSingleActivity() {
        final String endpointName = "/Activities/14";
        String url = apiUrl + endpointName;

        Request request = new Request.Builder()
                .url(url)
                .header("accept", "text/plain; v=1.0")
                .build();
        try (Response response = client.newCall(request).execute()) {
            int code = response.code();
            String responseBody = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Activity activity = objectMapper.readValue(responseBody, Activity.class);
            Assert.assertEquals(activity.getId(), 14, "Response body must contain id with value 14, but it doesn't.");
            Assert.assertEquals(activity.getTitle(), "Activity 14", "Response body must contain title with value 'Activity 14', but it doesn't.");
            Assert.assertEquals(code, 200, "Response code must be 200, but we got " + code + "instead.");
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

    @Test
    public void postActivities() throws IOException {
        final String endpoint = "/Activities";
        String url = apiUrl+endpoint;

        String addActivity =
                "{\n" +
                "  \"id\": 0,\n" +
                "  \"title\": \"string\",\n" +
                "  \"dueDate\": \"2024-02-04T18:57:18.126Z\",\n" +
                "  \"completed\": true\n" +
                "}";

        String expectedResponse = "{\"id\":0,\"title\":\"string\",\"dueDate\":\"2024-02-04T18:57:18.126Z\",\"completed\":true}";

        JSONObject json = new JSONObject(addActivity);

        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("POST", RequestBody.create(String.valueOf(json), MediaType.get("application/json")))
                .build();
        Response response = client.newCall(request).execute();
        int code = response.code();
        Assert.assertEquals(code, 200);

        String responseBody = response.body().string();
        Assert.assertEquals(responseBody, expectedResponse);
    }
}