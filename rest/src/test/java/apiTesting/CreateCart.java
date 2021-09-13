package apiTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Create Cart");
		RestAssured.baseURI="http://democart.qapitol.com";
		
		Response response=RestAssured.given()
			.header("Content-Type","application/json")
			.when()
			.post("/api/v2/storefront/cart")
			.then().assertThat().statusCode(201)
			.log().all().extract().response();
		


		System.out.println("Response: "+response.asPrettyString());
		
		
	}

}
