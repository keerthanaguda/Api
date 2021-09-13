package serializationAndDeserialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessTokenRequest {


	@JsonProperty("grant_type")
	private String grantType;
	
	@JsonProperty("username")
	private String userName;
	
	private String password;
	
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public AccessTokenRequest() {

	}
	
	public AccessTokenRequest(String grantType, String userName, String password) {
		super();
		this.grantType = grantType;
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "AccessTokenRequest [grantType=" + grantType + ", userName=" + userName + ", password=" + password
				+ ", getGrantType()=" + getGrantType() + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
