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
import static br.com.fiap.tech.challenge.fixture.CreateProductRequestFixture.UpdateProductRequestModel;
import static br.com.fiap.tech.challenge.fixture.Fixture.create;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TestConfiguration.class
)
@ActiveProfiles({ "test" })
@Testcontainers
public class UpdateProductResourceIT {

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
    void shouldUpdatedProduct() {
        var request = create(UpdateProductRequestModel());

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
            .when()
                .put("/product")
            .then()
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchemaInClasspath("./schemas/SingleProductResponseSchema.json"));
    }
}
