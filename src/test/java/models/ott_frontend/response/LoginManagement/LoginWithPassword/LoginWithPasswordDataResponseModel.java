package models.ott_frontend.response.LoginManagement.LoginWithPassword;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginWithPasswordDataResponseModel {

	@SerializedName("refreshToken")
	@Expose
	private Object refreshToken;
	@SerializedName("accessToken")
	@Expose
	private String accessToken;
	@SerializedName("expiresIn")
	@Expose
	private Object expiresIn;
	@SerializedName("pubnubChannel")
	@Expose
	private String pubnubChannel;
	@SerializedName("crmId")
	@Expose
	private String crmId;
	@SerializedName("forceChangePwd")
	@Expose
	private Boolean forceChangePwd;
	@SerializedName("isFirstTimeLoggedIn")
	@Expose
	private Boolean isFirstTimeLoggedIn;
	@SerializedName("encryptedPassword")
	@Expose
	private String encryptedPassword;
	@SerializedName("rrmSessionInfo")
	@Expose
	private LoginWithPasswordRRMSessionInfoResponseModel rrmSessionInfo;
	@SerializedName("userDetails")
	@Expose
	private LoginWithPasswordUserDetailsResponseModel userDetails;
	@SerializedName("userProfile")
	@Expose
	private LoginWithPasswordUserProfileResponseModel userProfile;
	@SerializedName("deviceDetails")
	@Expose
	private List<LoginWithPasswordDeviceDetailResponseModel> deviceDetails = new ArrayList<LoginWithPasswordDeviceDetailResponseModel>();

	public Object getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(Object refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Object getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Object expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getPubnubChannel() {
		return pubnubChannel;
	}

	public void setPubnubChannel(String pubnubChannel) {
		this.pubnubChannel = pubnubChannel;
	}

	public String getCrmId() {
		return crmId;
	}

	public void setCrmId(String crmId) {
		this.crmId = crmId;
	}

	public Boolean getForceChangePwd() {
		return forceChangePwd;
	}

	public void setForceChangePwd(Boolean forceChangePwd) {
		this.forceChangePwd = forceChangePwd;
	}

	public Boolean getIsFirstTimeLoggedIn() {
		return isFirstTimeLoggedIn;
	}

	public void setIsFirstTimeLoggedIn(Boolean isFirstTimeLoggedIn) {
		this.isFirstTimeLoggedIn = isFirstTimeLoggedIn;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public LoginWithPasswordRRMSessionInfoResponseModel getRrmSessionInfo() {
		return rrmSessionInfo;
	}

	public void setRrmSessionInfo(LoginWithPasswordRRMSessionInfoResponseModel rrmSessionInfo) {
		this.rrmSessionInfo = rrmSessionInfo;
	}

	public LoginWithPasswordUserDetailsResponseModel getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(LoginWithPasswordUserDetailsResponseModel userDetails) {
		this.userDetails = userDetails;
	}

	public LoginWithPasswordUserProfileResponseModel getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(LoginWithPasswordUserProfileResponseModel userProfile) {
		this.userProfile = userProfile;
	}

	public List<LoginWithPasswordDeviceDetailResponseModel> getDeviceDetails() {
		return deviceDetails;
	}

	public void setDeviceDetails(List<LoginWithPasswordDeviceDetailResponseModel> deviceDetails) {
		this.deviceDetails = deviceDetails;
	}

}
