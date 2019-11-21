package models.ott_frontend.request.NewFavorites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentList {

    @SerializedName("contentId")
    @Expose
    private Integer contentId;
    @SerializedName("contentType")
    @Expose
    private String contentType;

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
}
