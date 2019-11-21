package models.ATV;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AtvLoginRequestModel {

    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("hash")
    @Expose
    private String hash;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
