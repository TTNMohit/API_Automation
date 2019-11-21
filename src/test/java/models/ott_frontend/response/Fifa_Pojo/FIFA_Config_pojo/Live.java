package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Live {

    @SerializedName("sd")
    @Expose
    private Sd_ sd;
    @SerializedName("hd")
    @Expose
    private Hd_ hd;

    public Sd_ getSd() {
        return sd;
    }

    public void setSd(Sd_ sd) {
        this.sd = sd;
    }

    public Hd_ getHd() {
        return hd;
    }

    public void setHd(Hd_ hd) {
        this.hd = hd;
    }

}
