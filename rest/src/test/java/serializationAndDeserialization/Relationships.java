package serializationAndDeserialization;

public class Relationships {
	
	private DefaultBillingAddress default_billing_address;
	private DefaultShippingAddress default_shipping_address;
	
	public DefaultBillingAddress getDefault_billing_address() {
		return default_billing_address;
	}
	
	public void setDefault_billing_address(DefaultBillingAddress default_billing_address) {
		this.default_billing_address = default_billing_address;
	}
	
	public DefaultShippingAddress getDefault_shipping_address() {
		return default_shipping_address;
	}
	
	public void setDefault_shipping_address(DefaultShippingAddress default_shipping_address) {
		this.default_shipping_address = default_shipping_address;
	}
	
	

}
