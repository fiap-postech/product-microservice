package br.com.fiap.tech.challenge.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static br.com.fiap.tech.challenge.container.DatabaseContainers.localDatabaseContainer;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TestConfiguration.class
)
@ActiveProfiles({ "test" })
@Testcontainers
public class ManageProductResourceIT {

    private static final int LOCAL_PORT = 8688;

    @Container
    protected static final MySQLContainer<?> DATABASE = localDatabaseContainer();

    @BeforeAll
    static void beforeAll() {
        System.setProperty("spring.datasource.url", DATABASE.getJdbcUrl());
        System.setProperty("spring.datasource.username", DATABASE.getUsername());
        System.setProperty("spring.datasource.password", DATABASE.getPassword());

        System.setProperty("server.port", String.valueOf(LOCAL_PORT));

        RestAssured.port = LOCAL_PORT;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    @Test
    void shouldEnableAProduct() {
        var UUID = "ade7f71c-5642-4fff-9385-4b983a0f9a7d";

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
            .when()
                .patch("/product/{uuid}/enable", UUID)
            .then()
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchemaInClasspath("./schemas/SingleProductResponseSchema.json"));
    }

    @Test
    void shouldDisableAProduct() {
        var UUID = "ade7f71c-5642-4fff-9385-4b983a0f9a7d";

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
            .when()
                .patch("/product/{uuid}/disable", UUID)
            .then()
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchemaInClasspath("./schemas/SingleProductResponseSchema.json"));
    }
}
