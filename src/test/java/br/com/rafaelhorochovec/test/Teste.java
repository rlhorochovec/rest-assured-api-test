package br.com.rafaelhorochovec.test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Teste {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api"; // Set the base URI
    }

    @Test
    public void GETAll() {
        RestAssured
                .given()
                .when()
                .get("/users") // Send a GET request to /users/1
                .then()
                .statusCode(200); // Verify that the response status code is 200 (OK)
    }
}