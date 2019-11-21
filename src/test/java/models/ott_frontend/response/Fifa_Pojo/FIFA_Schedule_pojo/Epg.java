package models.ott_frontend.response.Fifa_Pojo.FIFA_Schedule_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Epg {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("startTime")
    @Expose
    private long startTime;
    @SerializedName("endTime")
    @Expose
    private long endTime;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("seriesId")
    @Expose
    private String seriesId;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("epgState")
    @Expose
    private String epgState;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("fifaWebUrl")
    @Expose
    private String fifaWebUrl;
    @SerializedName("channelMeta")
    @Expose
    private ChannelMeta channelMeta;
    @SerializedName("detail")
    @Expose
    private Detail detail;
    @SerializedName("catchup")
    @Expose
    private Boolean catchup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEpgState() {
        return epgState;
    }

    public void setEpgState(String epgState) {
        this.epgState = epgState;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getFifaWebUrl() {
        return fifaWebUrl;
    }

    public void setFifaWebUrl(String fifaWebUrl) {
        this.fifaWebUrl = fifaWebUrl;
    }

    public ChannelMeta getChannelMeta() {
        return channelMeta;
    }

    public void setChannelMeta(ChannelMeta channelMeta) {
        this.channelMeta = channelMeta;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Boolean getCatchup() {
        return catchup;
    }

    public void setCatchup(Boolean catchup) {
        this.catchup = catchup;
    }

}
