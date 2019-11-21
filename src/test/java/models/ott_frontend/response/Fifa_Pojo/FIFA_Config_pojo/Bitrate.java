package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bitrate {

    @SerializedName("vod")
    @Expose
    private Vod vod;
    @SerializedName("live")
    @Expose
    private Live live;

    public Vod getVod() {
        return vod;
    }

    public void setVod(Vod vod) {
        this.vod = vod;
    }

    public Live getLive() {
        return live;
    }

    public void setLive(Live live) {
        this.live = live;
    }

}
