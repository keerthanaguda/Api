package apiTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Get Cart");
		RestAssured.baseURI="http://democart.qapitol.com";
		
		Response response=RestAssured.given()
			.header("Content-Type","application/json")
			.header("X-Spree-Order-Token","Ix1yDDeXfsClgjgMc4qrSQ1620039335029")
			.when()
			.get("/api/v2/storefront/cart")
			.then().assertThat().statusCode(200)
			.log().all().extract().response();
		


		System.out.println("Response: "+response.asPrettyString());
		
	}

}
