package models.ott_frontend.response.Fifa_Pojo.FIFA_Schedule_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChannelMeta {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("assetId")
    @Expose
    private String assetId;
    @SerializedName("channelNumber")
    @Expose
    private String channelNumber;
    @SerializedName("genre")
    @Expose
    private List<String> genre = null;
    @SerializedName("hd")
    @Expose
    private Boolean hd;
    @SerializedName("favourite")
    @Expose
    private Boolean favourite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(String channelNumber) {
        this.channelNumber = channelNumber;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public Boolean getHd() {
        return hd;
    }

    public void setHd(Boolean hd) {
        this.hd = hd;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

}
