package models.ott_frontend.response.NewFavorite.Get_Subscriber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("pagingState")
    @Expose
    private String pagingState;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("list")
    @Expose
    private List<SubscriberList> subscriberList = null;

    public String getPagingState() {
        return pagingState;
    }

    public void setPagingState(String pagingState) {
        this.pagingState = pagingState;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<SubscriberList> getSubscriberList() {
        return subscriberList;
    }

    public void setSubscriberList(List<SubscriberList> subscriberList) {
        this.subscriberList = subscriberList;
    }

}
