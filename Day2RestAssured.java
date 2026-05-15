package automation_collections_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Day2RestAssured {
	
	
	@Test
	public void ts3() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		String requestbody = "{\"title\":\"Sridhar\",\r\n"
				+ "\"body\":\"QA Engineer\",\r\n"
				+ "\"userId\":1}";
		
		Response postResponse = RestAssured
				.given()
					.contentType("application/json")
					.body(requestbody)
				.when()
					.post("/posts")
				.then()
					.statusCode(201)
					.log().all().extract().response();
		
		int userId = postResponse.jsonPath().getInt("userId");
		
		System.out.println(userId);
		
		
		//put response
		String putRequestBody = "{\"userId\": 1,\r\n"
				+ "    \"id\": 2,\r\n"
				+ "    \"title\": \"qui est esse_updated\"}";
		
		
		Response putResponse = RestAssured
				.given()
					.contentType("application/json")
					.pathParam("Id", userId)
					.body(putRequestBody)
				.when()
					.put("/posts/{Id}")
				.then()
					.statusCode(200)
					.log().all().extract().response();
		
		String title = putResponse.jsonPath().getString("title");
		
		System.out.println(title);
		
		//Get Response
		Response getResponse = RestAssured
				.given()
					.contentType("application/json")
					.pathParam("Id", userId)
				.when()
					.get("/posts/{Id}")
				.then()
					.statusCode(200)
					.log().all().extract().response();
		
		String getTitle = getResponse.jsonPath().getString("title");
		
		System.out.println(getTitle);
		
		Assert.assertEquals(getTitle, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		
		
	}

	
}
