package models.ott_frontend.response.NewFavorite.IsFavorite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("subscriberId")
    @Expose
    private String subscriberId;
    @SerializedName("profileId")
    @Expose
    private String profileId;
    @SerializedName("contentId")
    @Expose
    private Integer contentId;
    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("isFavourite")
    @Expose
    private Boolean isFavourite;
    @SerializedName("secondsWatched")
    @Expose
    private Integer secondsWatched;
    @SerializedName("durationInSeconds")
    @Expose
    private Integer durationInSeconds;

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

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Boolean getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public Integer getSecondsWatched() {
        return secondsWatched;
    }

    public void setSecondsWatched(Integer secondsWatched) {
        this.secondsWatched = secondsWatched;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

}
