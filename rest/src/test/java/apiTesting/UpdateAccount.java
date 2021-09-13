package apiTesting;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Update Account");
		
		RestAssured.baseURI="http://democart.qapitol.com";
		Response response=RestAssured.given()
			.header("Content-Type","application/vnd.api+json")
			.body("{\r\n"
					+ " \"user\": {\r\n"
					+ "   \"email\": \"anish.kumar@qapitol.com\",\r\n"
					+ "   \"bill_address_id\": 1,\r\n"
					+ "   \"ship_address_id\": 1,\r\n"
					+ "   \"password\": \"anishj\",\r\n"
					+ "   \"password_confirmation\": \"anishj\"\r\n"
					+ " }\r\n"
					+ "}")
			.log().all()
			.when()
			.patch("/api/v2/storefront/account")
			.then().assertThat().statusCode(200)
			.log().all().extract().response();


		System.out.println("Response :"+ response.asPrettyString());
		String accesstoken=response.jsonPath().getString("access_token");
		System.out.println("access_token :"+ accesstoken);
		
//		Assert.assertEquals(response.statusCode(),200);
//		Assert.assertEquals(response.jsonPath().getString("token_type"), "Bearer");
//		Assert.assertNotNull(response.jsonPath().getString("access_token"));
	}

}
