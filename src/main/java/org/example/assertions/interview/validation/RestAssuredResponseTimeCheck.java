package org.example.assertions.interview.validation;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class RestAssuredResponseTimeCheck {
    public static void main(String[] args) {
        long responseTime = given()
                .auth()
                .digest("user", "COMMON_PASSWORD")
        .when()
                .get("http://localhost:7071/api/all_contacts")
        .then()
                .statusCode(200)
                .time(lessThan(600L))
                .time(lessThanOrEqualTo(550L), TimeUnit.MILLISECONDS)
                .extract()
                .time();

        if(responseTime > 500) {
            System.out.println("WARNING: RESPONSE HAS CROSSED 500ms");
        }
    }
}

