package org.example.assertions.interview.authentication;

import static io.restassured.RestAssured.given;

public class RestAssuredOAuth2 {
    public static void main(String[] args) {
        String accessToken = "<ACCESS TOKEN>";
        given()
                .auth()
                .oauth2(accessToken)
                .body("{\n" +
                        "    \"phoneNumber\": 9876543210,\n" +
                        "    \"userName\": \"User Name 2\",\n" +
                        "    \"phNumberType\": \"OFFICE\"\n" +
                        "}")
        .when()
                .post("http://localhost:7071/api/update_contact")
        .then()
                .statusCode(200);
    }
}
