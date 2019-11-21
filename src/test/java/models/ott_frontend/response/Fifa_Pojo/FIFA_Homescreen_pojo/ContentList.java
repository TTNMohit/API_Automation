package models.ott_frontend.response.Fifa_Pojo.FIFA_Homescreen_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContentList {

    @SerializedName("id")
    @Expose
    private long id;
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
    private List<String> subTitles = null;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("allowedOnBrowsers")
    @Expose
    private Boolean allowedOnBrowsers;
    @SerializedName("blackOut")
    @Expose
    private Boolean blackOut;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("providerContentId")
    @Expose
    private String providerContentId;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("airedDate")
    @Expose
    private long airedDate;
    @SerializedName("contractName")
    @Expose
    private String contractName;
    @SerializedName("entitlements")
    @Expose
    private List<String> entitlements = null;
    @SerializedName("epgState")
    @Expose
    private String epgState;
    @SerializedName("channelId")
    @Expose
    private Integer channelId;
    @SerializedName("genre")
    @Expose
    private List<String> genre = null;
    @SerializedName("language")
    @Expose
    private List<String> language = null;
    @SerializedName("duration")
    @Expose
    private String duration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<String> getSubTitles() {
        return subTitles;
    }

    public void setSubTitles(List<String> subTitles) {
        this.subTitles = subTitles;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getAllowedOnBrowsers() {
        return allowedOnBrowsers;
    }

    public void setAllowedOnBrowsers(Boolean allowedOnBrowsers) {
        this.allowedOnBrowsers = allowedOnBrowsers;
    }

    public Boolean getBlackOut() {
        return blackOut;
    }

    public void setBlackOut(Boolean blackOut) {
        this.blackOut = blackOut;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderContentId() {
        return providerContentId;
    }

    public void setProviderContentId(String providerContentId) {
        this.providerContentId = providerContentId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public long getAiredDate() {
        return airedDate;
    }

    public void setAiredDate(long airedDate) {
        this.airedDate = airedDate;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public List<String> getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(List<String> entitlements) {
        this.entitlements = entitlements;
    }

    public String getEpgState() {
        return epgState;
    }

    public void setEpgState(String epgState) {
        this.epgState = epgState;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
