package serializationAndDeserialization;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateAccountApiTest {

	public static void main(String[] args) {

		CreateAccountRequest caq=new CreateAccountRequest();
		caq.setEmail("manasa20@gmail.com");
		caq.setPassword("spree123");
		caq.setPassword_confirmation("spree123");
		
		RestAssured.baseURI="http://democart.qapitol.com";
		
		Response response=RestAssured.given()
				.header("Content-Type","application/json")
				.body(caq)
				.log().all()
				.when()
				.post("/api/v2/storefront/account")
				.then()
				.assertThat().statusCode(422)
				.log().all().extract().response();
		
		System.out.println("Response : "+ response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 422);
		
		CreateAccountResponse car = response.body().as(CreateAccountResponse.class);
		
		System.out.println("access_token res: " + CreateAccountResponse.getAccessToken());
		System.out.println("token_type res: " + CreateAccountResponse.getTokenType());

	}

}
