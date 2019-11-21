package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hd_ {

    @SerializedName("low")
    @Expose
    private Integer low;
    @SerializedName("medium")
    @Expose
    private Integer medium;
    @SerializedName("high")
    @Expose
    private Integer high;
    @SerializedName("def")
    @Expose
    private Integer def;

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getMedium() {
        return medium;
    }

    public void setMedium(Integer medium) {
        this.medium = medium;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

}
