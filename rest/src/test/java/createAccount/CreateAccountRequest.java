package createAccount;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountRequest {

	@JsonProperty("user")
	private CreateAccountUser user;
	
	


	public CreateAccountUser getUser() {
		return user;
	}


	public void setUser(CreateAccountUser user) {
		this.user = user;
		
	}

	public CreateAccountRequest( ) {
	}
	
	@Override
	public String toString() {
		return "CreateAccountRequest [user=" + user + "]";
	}
}
