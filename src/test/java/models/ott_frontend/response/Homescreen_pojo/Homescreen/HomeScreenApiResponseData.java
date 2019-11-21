package models.ott_frontend.response.Homescreen_pojo.Homescreen;



public class HomeScreenApiResponseData {
	private String message;

	private Data data;

	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ClassPojo [message = " + message + ", data = " + data
				+ ", code = " + code + "]";
	}
}