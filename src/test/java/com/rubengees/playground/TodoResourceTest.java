package com.rubengees.playground;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class TodoResourceTest {

    @Test
    public void testTodosEndpoint() {
        given()
                .when().get("/todos")
                .then()
                .statusCode(200);
    }
}
