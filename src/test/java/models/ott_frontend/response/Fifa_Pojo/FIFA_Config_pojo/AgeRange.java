package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgeRange {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("isKids")
    @Expose
    private Boolean isKids;
    @SerializedName("isRegular")
    @Expose
    private Boolean isRegular;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getIsKids() {
        return isKids;
    }

    public void setIsKids(Boolean isKids) {
        this.isKids = isKids;
    }

    public Boolean getIsRegular() {
        return isRegular;
    }

    public void setIsRegular(Boolean isRegular) {
        this.isRegular = isRegular;
    }

}