package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IOS {

    @SerializedName("recommendedVersion")
    @Expose
    private String recommendedVersion;
    @SerializedName("forceUpgradeVersion")
    @Expose
    private String forceUpgradeVersion;

    public String getRecommendedVersion() {
        return recommendedVersion;
    }

    public void setRecommendedVersion(String recommendedVersion) {
        this.recommendedVersion = recommendedVersion;
    }

    public String getForceUpgradeVersion() {
        return forceUpgradeVersion;
    }

    public void setForceUpgradeVersion(String forceUpgradeVersion) {
        this.forceUpgradeVersion = forceUpgradeVersion;
    }

}