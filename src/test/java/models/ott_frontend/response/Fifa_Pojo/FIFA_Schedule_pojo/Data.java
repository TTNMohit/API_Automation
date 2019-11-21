package models.ott_frontend.response.Fifa_Pojo.FIFA_Schedule_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("date")
    @Expose
    private long date;
    @SerializedName("fifaWebUrl")
    @Expose
    private String fifaWebUrl;
    @SerializedName("schedule")
    @Expose
    private List<Schedule> schedule = null;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getFifaWebUrl() {
        return fifaWebUrl;
    }

    public void setFifaWebUrl(String fifaWebUrl) {
        this.fifaWebUrl = fifaWebUrl;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

}
