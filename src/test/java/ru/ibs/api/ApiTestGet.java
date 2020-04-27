package ru.ibs.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTestGet {

    @Test()
    public void testGet() {
        List<String> jsonFields = new ArrayList<>();
        jsonFields.add("page");
        jsonFields.add("per_page");
        jsonFields.add("total");
        jsonFields.add("total_pages");
        jsonFields.add("data.id");
        jsonFields.add("data.email");
        jsonFields.add("data.first_name");
        jsonFields.add("data.last_name");
        jsonFields.add("data.avatar");

        Response response =
                given()
                .log().all()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        for (int i = 0; i < jsonFields.size(); i++) {
            String param = response.jsonPath().getString(jsonFields.get(i));
            Assert.assertTrue(!param.isEmpty(), "Поле " + jsonFields.get(i) + " путое.");
        }

    }

}
