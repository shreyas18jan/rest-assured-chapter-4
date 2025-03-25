package org.example.assertions.interview.authentication;

import static io.restassured.RestAssured.given;

public class RestAssuredHeaderAuthorization {
    public static void main(String[] args) {
        String token = "<BEARER TOKEN>";

        given()
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"phoneNumber\": 9876543210,\n" +
                        "    \"userName\": \"User Name 2\",\n" +
                        "    \"phNumberType\": \"OFFICE\"\n" +
                        "}")
        .when()
                .post("http://localhost:7071/api/create_contact")
        .then()
                .statusCode(200);
    }
}
