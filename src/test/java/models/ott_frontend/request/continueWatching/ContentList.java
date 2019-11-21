package models.ott_frontend.request.continueWatching;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentList {

    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("contentId")
    @Expose
    private Integer contentId;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }
}
