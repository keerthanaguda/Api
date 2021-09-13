package getAccount;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import serializationAndDeserialization.AccessTokenRequest;
import serializationAndDeserialization.AccessTokenResponse;

public class ApiTest {

//	private static String reqBody = "{\r\n"
//			+ "    \"grant_type\": \"password\",\r\n"
//			+ "    \"username\": \"democart@gmail.com\",\r\n"
//			+ "    \"password\": \"democart\"\r\n"
//			+ "}";
	
	
	@Test(priority=1)
	public void getAccessToken () {
		AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
		accessTokenRequest.setGrantType("password");
		accessTokenRequest.setUserName("democart@gmail.com");
		accessTokenRequest.setPassword("democart");
		
		System.out.println("First API" + accessTokenRequest);
		
		RestAssured.baseURI = "http://democart.qapitol.com";
		
		Response response = RestAssured
			.given()
				.header("Content-Type","application/json")
				.body(accessTokenRequest)
				.log().all()
			.when()
				.post("/spree_oauth/token")
			.then()
				.assertThat().statusCode(200)
				.extract().response();
		
		System.out.println("Response : " + response.asPrettyString());
		
		AccessTokenResponse accessTokenResponse = response.body().as(AccessTokenResponse.class);
		
		System.out.println("access_token res: " + accessTokenResponse.getAccessToken());
		System.out.println("token_type res: " + accessTokenResponse.getTokenType());
		

		
		
		System.out.println("Get Account");
		Response getAccountResponse=RestAssured.given()
				.header("Content-Type","application/json")
				.header("Authorization","Bearer "+ accessTokenResponse.getAccessToken())
				.when()
				.get("/api/v2/storefront/account")
				.then()
				.assertThat().statusCode(200)
				.log().all().extract().response();
		
		
		
		System.out.println("Get Account Response: "+getAccountResponse.asPrettyString());
		System.out.println("access_token: " + accessTokenResponse.getAccessToken());
		
		GetAccountDataResponse gadr=new GetAccountDataResponse();
		
		GetAccountDataResponse getAccountDataResponse=getAccountResponse.body().as(GetAccountDataResponse.class);
		System.out.println("response: "+getAccountDataResponse);
		
		System.out.println("id :"+ getAccountDataResponse.getData().getId());
		
		
	}
}

