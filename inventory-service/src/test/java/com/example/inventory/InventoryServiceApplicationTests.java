package com.example.inventory;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void checksInventory() {
		var inStock = RestAssured.given()
				.when()
				.get("/api/v1/inventories?skuCode=iPhone_15&quantity=1")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		assertTrue(inStock);

		var outOfStock = RestAssured.given()
				.when()
				.get("/api/v1/inventories?skuCode=galaxy_24&quantity=115")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		assertFalse(outOfStock);
	}

}
