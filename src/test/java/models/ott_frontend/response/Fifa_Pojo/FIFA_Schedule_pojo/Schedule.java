package models.ott_frontend.response.Fifa_Pojo.FIFA_Schedule_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule {

    @SerializedName("matchId")
    @Expose
    private String matchId;
    @SerializedName("fifa")
    @Expose
    private Fifa fifa;
    @SerializedName("epg")
    @Expose
    private Epg epg;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Fifa getFifa() {
        return fifa;
    }

    public void setFifa(Fifa fifa) {
        this.fifa = fifa;
    }

    public Epg getEpg() {
        return epg;
    }

    public void setEpg(Epg epg) {
        this.epg = epg;
    }

}
