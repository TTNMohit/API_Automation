package models.ott_frontend.response.ProfileManagement.ListOfProfiles;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListOfProfilesDataResponseModel {

	@SerializedName("profiles")
	@Expose
	private List<ListOfProfilesResponseModel> profiles = null;
	@SerializedName("isPLExist")
	@Expose
	private Boolean isPLExist;

	public List<ListOfProfilesResponseModel> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<ListOfProfilesResponseModel> profiles) {
		this.profiles = profiles;
	}

	public Boolean getIsPLExist() {
		return isPLExist;
	}

	public void setIsPLExist(Boolean isPLExist) {
		this.isPLExist = isPLExist;
	}

}
