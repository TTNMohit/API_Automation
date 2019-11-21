package models.ott_frontend.response.LoginManagement.Logout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutMainResponseModel {

	@SerializedName("code")
	@Expose
	private Integer code;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("data")
	@Expose
	private LogoutDataResponseModel data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LogoutDataResponseModel getData() {
		return data;
	}

	public void setData(LogoutDataResponseModel data) {
		this.data = data;
	}

}
