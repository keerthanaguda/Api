package apiTesting;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("List Of Products");
		
		RestAssured.baseURI="http://democart.qapitol.com";
		
		Response response=RestAssured.given()
			.header("Content-Type","application/json")
			.when()
			.get("/api/v2/storefront/products/139")
			.then().assertThat().statusCode(200)
			.log().all().extract().response();
		
		System.out.println("Response: "+response.asPrettyString());
		Assert.assertEquals(response.statusCode(),200);	
	}

}
