package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo.AgeRange;

import java.util.List;

public class Profile {

    @SerializedName("ageRange")
    @Expose
    private List<AgeRange> ageRange = null;
    @SerializedName("awsBucket")
    @Expose
    private String awsBucket;
    @SerializedName("maxProfileCount")
    @Expose
    private Integer maxProfileCount;
    @SerializedName("genders")
    @Expose
    private List<String> genders = null;
    @SerializedName("awsUrl")
    @Expose
    private String awsUrl;

    public List<AgeRange> getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(List<AgeRange> ageRange) {
        this.ageRange = ageRange;
    }

    public String getAwsBucket() {
        return awsBucket;
    }

    public void setAwsBucket(String awsBucket) {
        this.awsBucket = awsBucket;
    }

    public Integer getMaxProfileCount() {
        return maxProfileCount;
    }

    public void setMaxProfileCount(Integer maxProfileCount) {
        this.maxProfileCount = maxProfileCount;
    }

    public List<String> getGenders() {
        return genders;
    }

    public void setGenders(List<String> genders) {
        this.genders = genders;
    }

    public String getAwsUrl() {
        return awsUrl;
    }

    public void setAwsUrl(String awsUrl) {
        this.awsUrl = awsUrl;
    }

}
