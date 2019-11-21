package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("cloudAccountUrl")
    @Expose
    private String cloudAccountUrl;
    @SerializedName("cloudSubAccountUrl")
    @Expose
    private String cloudSubAccountUrl;

    public String getCloudAccountUrl() {
        return cloudAccountUrl;
    }

    public void setCloudAccountUrl(String cloudAccountUrl) {
        this.cloudAccountUrl = cloudAccountUrl;
    }

    public String getCloudSubAccountUrl() {
        return cloudSubAccountUrl;
    }

    public void setCloudSubAccountUrl(String cloudSubAccountUrl) {
        this.cloudSubAccountUrl = cloudSubAccountUrl;
    }

}
