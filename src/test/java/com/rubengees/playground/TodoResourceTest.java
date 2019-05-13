package com.rubengees.playground;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class TodoResourceTest {

    @Test
    public void testTodosEndpoint() {
        given()
                .header("Content-Type", "application/json")
                .body(new Todo("Test", "description", true), ObjectMapperType.JACKSON_2)
                .when().post("/todos")
                .then()
                .statusCode(204);

        given()
                .when().get("/todos")
                .then()
                .statusCode(200)
                .body("", hasSize(1));
    }
}
