package models.ott_frontend.request.NewFavorites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeleteSubscriberRequestModel {

    @SerializedName("contentList")
    @Expose
    private List<ContentList> contentList = null;

    public List<ContentList> getContentList() {
        return contentList;
    }

    public void setContentList(List<ContentList> contentList) {
        this.contentList = contentList;
    }

}
