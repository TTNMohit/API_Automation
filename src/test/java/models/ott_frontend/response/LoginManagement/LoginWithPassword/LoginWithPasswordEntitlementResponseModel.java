package models.ott_frontend.response.LoginManagement.LoginWithPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginWithPasswordEntitlementResponseModel {

@SerializedName("type")
@Expose
private String type;
@SerializedName("pkgId")
@Expose
private String pkgId;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getPkgId() {
return pkgId;
}

public void setPkgId(String pkgId) {
this.pkgId = pkgId;
}

}