package models.ott_frontend.response.ProfileManagement.AddProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddProfileMainResponseModel {

	@SerializedName("code")
	@Expose
	private Integer code;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("data")
	@Expose
	private AddProfileDataResponseModel data;

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

	public AddProfileDataResponseModel getData() {
		return data;
	}

	public void setData(AddProfileDataResponseModel data) {
		this.data = data;
	}

}