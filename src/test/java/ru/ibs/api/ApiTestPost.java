package ru.ibs.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTestPost {

    @Test()
    public void testPost() {

        Map<String, String> data = new HashMap<>();
        data.put("name", "Test Testing");
        data.put("job", "QA lead");

        Response response =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .post("https://reqres.in/api/users")
                        .then()
                        .log().all()
                        .extract()
                        .response();

        data.forEach((k, v) -> {
            String param = response.jsonPath().get(k);
            Assert.assertTrue(param.equals(v), "Поле " + k + " путое.");
        });
    }

}
