package models.ott_frontend.request.continueWatching;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContinueWatchingRequestModel {

@SerializedName("subscriberId")
@Expose
private String subscriberId;
@SerializedName("profileId")
@Expose
private String profileId;

public String getSubscriberId() {
return subscriberId;
}

public void setSubscriberId(String subscriberId) {
this.subscriberId = subscriberId;
}

public String getProfileId() {
return profileId;
}

public void setProfileId(String profileId) {
this.profileId = profileId;
}

}