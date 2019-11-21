package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppUpgrade {

    @SerializedName("android")
    @Expose
    private Android android;
    @SerializedName("iOS")
    @Expose
    private IOS iOS;

    public Android getAndroid() {
        return android;
    }

    public void setAndroid(Android android) {
        this.android = android;
    }

    public IOS getIOS() {
        return iOS;
    }

    public void setIOS(IOS iOS) {
        this.iOS = iOS;
    }

}
