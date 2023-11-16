package br.com.rafaelhorochovec.test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void GETAll() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200).log().body();
    }

    @Test
    public void GETPage() {
        given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200).log().body();
    }

    @Test
    public void GETUser() {
        given()
                .when()
                .get("/users/6")
                .then()
                .statusCode(200).log().body();
    }

    @Test
    public void POSTUser() {
        String requestBody = "{\n" +
                "  \"name\": \"hulk\",\n" +
                "  \"job\": \"hero\" \n}";
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .statusCode(201).log().body();
    }

    @Test
    public void PUTUser() {
        String requestBody = "{\n" +
                "  \"name\": \"hulk\",\n" +
                "  \"job\": \"teacher\" \n}";
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/users/598")
                .then()
                .statusCode(200).log().body();
    }

    @Test
    public void PATCHUser() {
        String requestBody = "{\n" +
                "  \"name\": \"hulk\",\n" +
                "  \"job\": \"qa\" \n}";
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/users/598")
                .then()
                .statusCode(200).log().body();
    }

    @Test
    public void DELUser() {
        given()
                .when()
                .delete("/users/258")
                .then()
                .statusCode(204).log().body();
    }
}