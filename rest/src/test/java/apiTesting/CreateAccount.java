package apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateAccount {

	
	@Test(priority=1)		
	public void createAccount(){
		System.out.println("Create Account");
		
		RestAssured.baseURI="http://democart.qapitol.com";
		
		Response response=RestAssured.given()
			.header("Content-Type","application/vnd.api+json")
			.body("{\r\n"
					+ " \"user\": {\r\n"
					+ "   \"email\": \"john67564@snow.org\",\r\n"
					+ "   \"password\": \"spree123\",\r\n"
					+ "   \"password_confirmation\": \"spree123\"\r\n"
					+ " }\r\n"
					+ "}")
			.when()
				.post("/api/v2/storefront/account")
				.then()
					.assertThat().statusCode(422)
					.log().all().extract().response();
		
		System.out.println("Response: "+ response.asString());
		System.out.println("Response: "+ response.asPrettyString());
		
		Assert.assertEquals(200, response.statusCode());
//		Assert.assertEquals(response.jsonPath().getString("data.type"), "user");
//		Assert.assertEquals(response.jsonPath().getString("data.attributes.email"), "john67524@snow.org");

	}
	
	@Test(priority=2)
	public void invalidSignUp() {
		
		System.out.println("create account with invalid credentials");
		
		RestAssured.baseURI="http://democart.qapitol.com";
		
		Response response=RestAssured.given()
			.header("Content-Type","application/vnd.api+json")
			.body("\r\n"
					+ " \"user\": {\r\n"
					+ "   \"email\": \"j\",\r\n"
					+ "   \"password\": \"spree123\",\r\n"
					+ "   \"password_confirmation\": \"spree123\"\r\n"
					+ " }\r\n"
					+ "}")
			.when()
				.post("/api/v2/storefront/account")
				.then()
					.assertThat().statusCode(422)
					.log().all().extract().response();
		


		System.out.println("Response: "+ response.asPrettyString());
	}
	

}
