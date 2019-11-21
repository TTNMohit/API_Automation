package models.ott_frontend.request.LoginManagement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequestModel {

@SerializedName("sid")
@Expose
private String sid;
@SerializedName("pwd")
@Expose
private String pwd;

public String getSid() {
return sid;
}

public void setSid(String sid) {
this.sid = sid;
}

public String getPwd() {
return pwd;
}

public void setPwd(String pwd) {
this.pwd = pwd;
}

public LoginRequestModel(String subsriptionId, String password) {
	this.sid = subsriptionId;
	this.pwd = password;	
}
	
}
