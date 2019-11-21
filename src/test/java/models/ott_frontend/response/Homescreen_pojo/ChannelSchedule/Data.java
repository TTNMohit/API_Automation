package models.ott_frontend.response.Homescreen_pojo.ChannelSchedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("date")
    @Expose
    private long date;
    @SerializedName("epg")
    @Expose
    private List<Epg> epg = null;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public List<Epg> getEpg() {
        return epg;
    }

    public void setEpg(List<Epg> epg) {
        this.epg = epg;
    }

}
