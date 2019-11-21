package models.ott_frontend.response.Fifa_Pojo.FIFA_Schedule_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Detail {

    @SerializedName("contractName")
    @Expose
    private String contractName;
    @SerializedName("entitlements")
    @Expose
    private List<String> entitlements = null;
    @SerializedName("playUrl")
    @Expose
    private String playUrl;
    @SerializedName("trailerUrl")
    @Expose
    private String trailerUrl;
    @SerializedName("licenseUrl")
    @Expose
    private String licenseUrl;

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

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

}
