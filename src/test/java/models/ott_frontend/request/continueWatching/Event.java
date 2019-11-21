package models.ott_frontend.request.continueWatching;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {
    @SerializedName("subscriberId")
    @Expose
    private String subscriberId;
    @SerializedName("profileId")
    @Expose
    private String profileId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("watchDuration")
    @Expose
    private Integer watchDuration;
    @SerializedName("vodId")
    @Expose
    private Integer vodId;
    @SerializedName("totalDuration")
    @Expose
    private Integer totalDuration;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getWatchDuration() {
        return watchDuration;
    }

    public void setWatchDuration(Integer watchDuration) {
        this.watchDuration = watchDuration;
    }

    public Integer getVodId() {
        return vodId;
    }

    public void setVodId(Integer vodId) {
        this.vodId = vodId;
    }

    public Integer getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Integer totalDuration) {
        this.totalDuration = totalDuration;
    }
}
