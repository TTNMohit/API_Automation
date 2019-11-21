package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vod {

    @SerializedName("sd")
    @Expose
    private Sd sd;
    @SerializedName("hd")
    @Expose
    private Hd hd;

    public Sd getSd() {
        return sd;
    }

    public void setSd(Sd sd) {
        this.sd = sd;
    }

    public Hd getHd() {
        return hd;
    }

    public void setHd(Hd hd) {
        this.hd = hd;
    }

}
