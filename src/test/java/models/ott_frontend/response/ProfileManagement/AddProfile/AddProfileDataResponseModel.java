package models.ott_frontend.response.ProfileManagement.AddProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddProfileDataResponseModel {

	@SerializedName("profileId")
	@Expose
	private String profileId;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

}