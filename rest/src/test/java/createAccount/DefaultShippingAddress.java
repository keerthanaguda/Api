package createAccount;

public class DefaultShippingAddress {

	private String data;

	public DefaultShippingAddress(String data) {
	
		this.data = data;
	}

	@Override
	public String toString() {
		return "DefaultShippingAddress [data=" + data + "]";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public DefaultShippingAddress() {
		
	}
	
}
