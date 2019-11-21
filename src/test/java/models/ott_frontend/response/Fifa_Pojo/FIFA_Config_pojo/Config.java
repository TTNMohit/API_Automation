package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Config {

    @SerializedName("fifa")
    @Expose
    private Fifa fifa;
    @SerializedName("enabledFeatures")
    @Expose
    private List<String> enabledFeatures = null;
    @SerializedName("dongleDeviceName")
    @Expose
    private String dongleDeviceName;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("cw_position")
    @Expose
    private Integer cwPosition;
    @SerializedName("cw_interval")
    @Expose
    private Integer cwInterval;
    @SerializedName("bitrate")
    @Expose
    private Bitrate bitrate;
    @SerializedName("terms_condition")
    @Expose
    private TermsCondition termsCondition;
    @SerializedName("url")
    @Expose
    private Url url;

    public Fifa getFifa() {
        return fifa;
    }

    public void setFifa(Fifa fifa) {
        this.fifa = fifa;
    }

    public List<String> getEnabledFeatures() {
        return enabledFeatures;
    }

    public void setEnabledFeatures(List<String> enabledFeatures) {
        this.enabledFeatures = enabledFeatures;
    }

    public String getDongleDeviceName() {
        return dongleDeviceName;
    }

    public void setDongleDeviceName(String dongleDeviceName) {
        this.dongleDeviceName = dongleDeviceName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Integer getCwPosition() {
        return cwPosition;
    }

    public void setCwPosition(Integer cwPosition) {
        this.cwPosition = cwPosition;
    }

    public Integer getCwInterval() {
        return cwInterval;
    }

    public void setCwInterval(Integer cwInterval) {
        this.cwInterval = cwInterval;
    }

    public Bitrate getBitrate() {
        return bitrate;
    }

    public void setBitrate(Bitrate bitrate) {
        this.bitrate = bitrate;
    }

    public TermsCondition getTermsCondition() {
        return termsCondition;
    }

    public void setTermsCondition(TermsCondition termsCondition) {
        this.termsCondition = termsCondition;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

}
