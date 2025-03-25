package org.example.assertions.interview.validation;

import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestAssuredJsonSchemaValidation {
    public static void main(String[] args) {
        given()
                .auth()
                .digest("user", "COMMON_PASSWORD")
        .when()
                .get("http://localhost:7071/api/all_contacts")
        .then()
                .statusCode(200)
                .body(
                        JsonSchemaValidator
                                .matchesJsonSchema(
                                        new File("src/main/resources/jsonSchema")));
    }
}



