package models.ott_frontend.response.Homescreen_pojo.AllChannelList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Channel_List {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("subTitles")
    @Expose
    private java.util.List<String> subTitles = null;
    @SerializedName("contractName")
    @Expose
    private String contractName;
    @SerializedName("entitlements")
    @Expose
    private java.util.List<String> entitlements = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public java.util.List<String> getSubTitles() {
        return subTitles;
    }

    public void setSubTitles(java.util.List<String> subTitles) {
        this.subTitles = subTitles;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public java.util.List<String> getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(java.util.List<String> entitlements) {
        this.entitlements = entitlements;
    }

}

