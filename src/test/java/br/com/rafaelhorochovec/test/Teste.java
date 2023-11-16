package br.com.rafaelhorochovec.test;

import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Teste {
    
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void GETAll() {
        RestAssured
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(200).log().body();
    }

    @Test
    public void GETPage() {
        RestAssured
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200).log().body();
    }

    @Test
    public void GETUser() {
        RestAssured
                .given()
                .when()
                .get("/users/6")
                .then()
                .statusCode(200).log().body();
    }
}