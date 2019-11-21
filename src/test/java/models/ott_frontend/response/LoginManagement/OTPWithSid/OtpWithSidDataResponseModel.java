package models.ott_frontend.response.LoginManagement.OTPWithSid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpWithSidDataResponseModel {

	@SerializedName("rmn")
	@Expose
	private String rmn;

	public String getRmn() {
		return rmn;
	}

	public void setRmn(String rmn) {
		this.rmn = rmn;
	}

}