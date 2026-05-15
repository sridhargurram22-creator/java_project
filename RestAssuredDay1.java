package automation_collections_practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredDay1 {
	
	
	@Test
	public void restAssured() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		String requestbody = "{\"title\":\"Sridhar\",\r\n"
				+ "\"body\":\"QA Engineer\",\r\n"
				+ "\"userId\":1}";
		
		//API POST Call
		Response postResponse = RestAssured
				.given()
					.contentType("application/json")
					.body(requestbody)
				.when()
					.post("/posts")
				.then()
					.statusCode(201)
					.log().all().extract().response();
		
		String userID = postResponse.jsonPath().getString("id");
		String title = postResponse.jsonPath().getString("title");
		
		System.out.println(title);
		
		System.out.println(userID + 1);
		
		//API GET call
		
		Response getResponse = RestAssured
				.given()
					.pathParam("id", 1)
				.when()
					.get("/posts/{id}")
				.then()
					.statusCode(200)
					.extract().response();
		
		String gettitle = getResponse.jsonPath().getString("title");
		String getId = getResponse.jsonPath().getString("id");
		
		SoftAssert a = new SoftAssert();
		
		a.assertEquals(gettitle, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		
		a.assertEquals(getId, "1");
		
		a.assertAll();
		
		
		
	}

}
