package apiTesting;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Create address");

		RestAssured.baseURI="http://democart.qapitol.com";
		
		Response response=RestAssured.given()
			.header("Content-Type","application/vnd.api+json")
			.body("{\r\n"
					+ " \"address\": {\r\n"
					+ "   \"firstname\": \"John\",\r\n"
					+ "   \"lastname\": \"Snow\",\r\n"
					+ "   \"address1\": \"7735 Old Georgetown Road\",\r\n"
					+ "   \"address2\": \"2nd Floor\",\r\n"
					+ "   \"city\": \"Bethesda\",\r\n"
					+ "   \"phone\": \"3014445002\",\r\n"
					+ "   \"zipcode\": \"20814\",\r\n"
					+ "   \"state_name\": \"MD\",\r\n"
					+ "   \"country_iso\": \"US\"\r\n"
					+ " }\r\n"
					+ "}")
			.log().all()
			.when()
			.post("/api/v2/storefront/account/addresses")
			.then()
			.assertThat().statusCode(200)
			.log().all().extract().response();
		


		System.out.println("Response: "+response.asPrettyString());
		
		String accesstoken=response.jsonPath().getString("access_token");
		System.out.println("access_token :"+ accesstoken);
		
		Assert.assertEquals(response.statusCode(),200);
		Assert.assertEquals(response.jsonPath().getString("token_type"), "Bearer");
		Assert.assertNotNull(response.jsonPath().getString("access_token"));

		
		
	}

}
