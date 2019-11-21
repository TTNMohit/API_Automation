package models.ott_frontend.request.continueWatching;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeleteViewingHistoryRequestModal {

    @SerializedName("subscriberId")
    @Expose
    private String subscriberId;
    @SerializedName("profileId")
    @Expose
    private String profileId;
    @SerializedName("contentList")
    @Expose
    private List<ContentList> contentList = null;

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

    public List<ContentList> getContentList() {
        return contentList;
    }

    public void setContentList(List<ContentList> contentList) {
        this.contentList = contentList;
    }

}

