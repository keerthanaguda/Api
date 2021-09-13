package apiTesting;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Authentication");

		RestAssured.baseURI="http://democart.qapitol.com";

		Response response=RestAssured.given()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"grant_type\": \"password\",\r\n"
				+ "    \"username\": \"anish.kumar@qapitol.com\",\r\n"
				+ "    \"password\": \"anishj\"\r\n"
				+ "}")
		.when()
		.post("/spree_oauth/token")
		.then()
		.assertThat().statusCode(200)
		.log().all().extract().response();
		
		System.out.println("Response: "+ response.asString());
		System.out.println("Response: "+ response.asPrettyString());
		
		String accesstoken=response.jsonPath().getString("access_token");
		System.out.println("access_token :"+ accesstoken);
		
		Assert.assertEquals(200, response.statusCode());
		Assert.assertEquals(response.jsonPath().getString("token_type"), "Bearer");
		Assert.assertNotNull(response.jsonPath().getString("access_token"));

		System.out.println("get response");

		RestAssured.baseURI="http://democart.qapitol.com";

		Response getresponse=RestAssured.given()
		.header("Content-Type","application/json")
		.header("Authorization","Bearer "+ accesstoken)
		.when()
		.get("/api/v2/storefront/account")
		.then()
		.assertThat().statusCode(200)
		.log().all().extract().response();
		


		System.out.println("Response: "+ getresponse.asPrettyString());

		Assert.assertEquals(200,getresponse.statusCode());
		Assert.assertEquals(getresponse.jsonPath().getString("data.type"), "user");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
