package org.example.assertions.interview.download;

import io.restassured.response.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestAssuredDownloadFile {
    public static void main(String[] args) {
        Response response = given()
                .auth()
                .digest("admin", "COMMON_ADMIN_PASSWORD")
        .when()
                .get("http://localhost:7071/extended/api/download_single_contact/9876543210")
        .then()
                .statusCode(200)
                .extract().response();

        // Save response body (file content) to a file
        String fileName = "/tmp/exampleContact.vcf";
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(response.getBody().asByteArray());
            System.out.println("File downloaded successfully: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving the file: " + e.getMessage());
        }
    }
}

