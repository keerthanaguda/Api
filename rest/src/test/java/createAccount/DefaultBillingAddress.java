package createAccount;

public class DefaultBillingAddress {
	
	private String data;

	public DefaultBillingAddress(String data) {
		this.data = data;
	}

	public DefaultBillingAddress() {
	
	}
	
	@Override
	public String toString() {
		return "DefaultBillingAddress [data=" + data + "]";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	

}
