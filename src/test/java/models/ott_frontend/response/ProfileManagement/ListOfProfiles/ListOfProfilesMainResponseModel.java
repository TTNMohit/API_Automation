package models.ott_frontend.response.ProfileManagement.ListOfProfiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListOfProfilesMainResponseModel {

	@SerializedName("code")
	@Expose
	private Integer code;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("data")
	@Expose
	private ListOfProfilesDataResponseModel data;

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

	public ListOfProfilesDataResponseModel getData() {
		return data;
	}

	public void setData(ListOfProfilesDataResponseModel data) {
		this.data = data;
	}

}