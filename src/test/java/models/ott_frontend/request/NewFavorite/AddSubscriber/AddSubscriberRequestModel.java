package models.ott_frontend.request.NewFavorite.AddSubscriber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddSubscriberRequestModel {

    @SerializedName("contentId")
    @Expose
    private String contentId;
    @SerializedName("contentType")
    @Expose
    private String contentType;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
