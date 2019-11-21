package models.ott_frontend.response.LoginManagement.LoginWithPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginWithPasswordMainResponseModel {

@SerializedName("code")
@Expose
private Integer code;
@SerializedName("message")
@Expose
private String message;
@SerializedName("data")
@Expose
private LoginWithPasswordDataResponseModel data;

public Integer getCode() {
return code;
}

public void setCode(Integer code) {
this.code = code;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public LoginWithPasswordDataResponseModel getData() {
return data;
}

public void setData(LoginWithPasswordDataResponseModel data) {
this.data = data;
}

}