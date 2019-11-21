package models.ott_frontend.response.LoginManagement.OTPWithSid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class OtpWithSidMainResponseModel {
	
	@SerializedName("code")
	@Expose
	private Integer code;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("data")
	@Expose
	private OtpWithSidDataResponseModel data;

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

	public OtpWithSidDataResponseModel getData() {
	return data;
	}

	public void setData(OtpWithSidDataResponseModel data) {
	this.data = data;
	}

}
