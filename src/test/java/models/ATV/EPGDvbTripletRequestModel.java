package models.ATV;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EPGDvbTripletRequestModel {

    @SerializedName("dvbTripletList")
    @Expose
    private List<String> dvbTripletList = null;
    @SerializedName("date")
    @Expose
    private String date;

    public List<String> getDvbTripletList() {
        return dvbTripletList;
    }

    public void setDvbTripletList(List<String> dvbTripletList) {
        this.dvbTripletList = dvbTripletList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}