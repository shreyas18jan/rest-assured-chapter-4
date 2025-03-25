package org.example.assertions.interview.validation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredCompleteJsonResponseAssertion {
    public static void main(String[] args) {
        String expectedFullResponse = "{\"phoneNumber\":9876543210," +
                "\"userName\":\"User Name 2\"," +
                "\"phNumberType\":\"OFFICE\"}";

        given().
                auth()
                .digest("user", "COMMON_PASSWORD")
        .when()
                .get("http://localhost:7071/api/9876543210")
        .then()
                .statusCode(200)
                .body(equalTo(expectedFullResponse));

    }
}



