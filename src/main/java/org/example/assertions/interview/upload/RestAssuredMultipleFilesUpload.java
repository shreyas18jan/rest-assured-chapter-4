package org.example.assertions.interview.upload;

import io.restassured.http.ContentType;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class RestAssuredMultipleFilesUpload {
    public static void main(String[] args) {
        given()
                .auth()
                .basic("admin", "COMMON_ADMIN_PASSWORD")
                .multiPart("file", new File("src/main/resources/BasicContact.vcf"))
                .multiPart("file", new File("src/main/resources/EmptyContact.vcf"))
                .contentType(ContentType.MULTIPART)
        .when()
                .post("http://localhost:7071/extended/api/upload_single_contact")
        .then()
                .statusCode(200)
                .body(containsString("Uploaded file successfully!"));

    }
}



