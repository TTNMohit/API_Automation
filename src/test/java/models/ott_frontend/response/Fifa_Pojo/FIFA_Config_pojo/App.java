package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class App {

    @SerializedName("appUpgrade")
    @Expose
    private AppUpgrade appUpgrade;

    public AppUpgrade getAppUpgrade() {
        return appUpgrade;
    }

    public void setAppUpgrade(AppUpgrade appUpgrade) {
        this.appUpgrade = appUpgrade;
    }

}
