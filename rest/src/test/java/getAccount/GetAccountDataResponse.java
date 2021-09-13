package getAccount;

public class GetAccountDataResponse
{
	
	private DataAttributes data;

	

	public GetAccountDataResponse(DataAttributes data) {
		this.data = data;
	}

	public GetAccountDataResponse() {
		
	}
	
	public DataAttributes getData() {
		return data;
	}

	public void setData(DataAttributes data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "GetAccountDataResponse [data=" + data + "]";
	}

}
