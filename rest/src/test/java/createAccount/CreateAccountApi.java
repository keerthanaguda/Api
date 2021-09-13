package createAccount;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateAccountApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CreateAccountRequest car=new CreateAccountRequest();
		CreateAccountUser user=new CreateAccountUser();
		
		car.setUser(user);
		user.setEmail("manasa96hjhdu@qapitol.com");
		user.setPassword("Admin1234");
		user.setPassword_confirmation("Admin1234");
		
		RestAssured.baseURI="http://democart.qapitol.com";
		
		Response response=RestAssured.given()
				.header("Content-Type","application/json")
				.body(car)
				.log().all()
				.when()
				.post("/api/v2/storefront/account")
				.then()
				.assertThat().statusCode(200)
				.extract().response();
		
		
		System.out.println("Response: "+response.asPrettyString());
		
		//Assert.assertEquals(response.statusCode(),200);
		
		//CreateAccountResponse createAccountResponse1=new CreateAccountResponse();
		CreateAccountResponse createAccountResponse=response.body().as(CreateAccountResponse.class);
		System.out.println("Create Account Response: "+ createAccountResponse);
		System.out.println("id: "+createAccountResponse.getData().getId());
		
		
	}

}
