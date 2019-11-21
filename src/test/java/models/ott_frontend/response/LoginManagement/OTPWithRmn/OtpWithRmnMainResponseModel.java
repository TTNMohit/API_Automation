package models.ott_frontend.response.LoginManagement.OTPWithRmn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpWithRmnMainResponseModel {

	@SerializedName("code")
	@Expose
	private Integer code;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("data")
	@Expose
	private OtpWithRmnDataResponseModel data;

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

	public OtpWithRmnDataResponseModel getData() {
		return data;
	}

	public void setData(OtpWithRmnDataResponseModel data) {
		this.data = data;
	}
}
