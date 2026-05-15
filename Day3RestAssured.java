package automation_collections_practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Day3RestAssured {
	
	@Test
	public void ts4() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		Response response = RestAssured
				.given()
					.contentType("application/json")
				.when()
					.get("/posts/1")
				.then()
					.statusCode(200)
					.log().all().extract().response();
		
	}

}
