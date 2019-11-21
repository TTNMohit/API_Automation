package models.ott_frontend.response.LoginManagement.SubscriberLookupWithRmn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubscriberLookupWithRmnMainResponseModel {

@SerializedName("code")
@Expose
private Integer code;
@SerializedName("message")
@Expose
private String message;
@SerializedName("data")
@Expose
private SubscriberLookupWithRmnDataResponseModel data;

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

public SubscriberLookupWithRmnDataResponseModel getData() {
return data;
}

public void setData(SubscriberLookupWithRmnDataResponseModel data) {
this.data = data;
}

}
