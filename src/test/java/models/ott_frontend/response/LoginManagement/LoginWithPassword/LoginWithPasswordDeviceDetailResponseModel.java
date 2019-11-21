package models.ott_frontend.response.LoginManagement.LoginWithPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginWithPasswordDeviceDetailResponseModel {

@SerializedName("friendlyName")
@Expose
private String friendlyName;
@SerializedName("deviceId")
@Expose
private String deviceId;
@SerializedName("model")
@Expose
private String model;
@SerializedName("manufacturer")
@Expose
private String manufacturer;

public String getFriendlyName() {
return friendlyName;
}

public void setFriendlyName(String friendlyName) {
this.friendlyName = friendlyName;
}

public String getDeviceId() {
return deviceId;
}

public void setDeviceId(String deviceId) {
this.deviceId = deviceId;
}

public String getModel() {
return model;
}

public void setModel(String model) {
this.model = model;
}

public String getManufacturer() {
return manufacturer;
}

public void setManufacturer(String manufacturer) {
this.manufacturer = manufacturer;
}

}
