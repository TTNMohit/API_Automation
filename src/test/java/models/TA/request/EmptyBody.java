package models.TA.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmptyBody {

    @SerializedName("empty_string")
    @Expose
    private String empty_string;

    public String getEmptyString() {
        return empty_string;
    }

    public void setEmptyString(String sid) {
        this.empty_string = empty_string;
    }
}
