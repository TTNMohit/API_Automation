package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fifa {

    @SerializedName("fifa_start_date")
    @Expose
    private String fifaStartDate;
    @SerializedName("fifa_end_date")
    @Expose
    private String fifaEndDate;

    public String getFifaStartDate() {
        return fifaStartDate;
    }

    public void setFifaStartDate(String fifaStartDate) {
        this.fifaStartDate = fifaStartDate;
    }

    public String getFifaEndDate() {
        return fifaEndDate;
    }

    public void setFifaEndDate(String fifaEndDate) {
        this.fifaEndDate = fifaEndDate;
    }

}
