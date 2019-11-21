package models.ott_frontend.response.LoginManagement.SubscriberLookupWithRmn;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubscriberLookupWithRmnSidListResponseModel {

@SerializedName("sid")
@Expose
private String sid;
@SerializedName("sName")
@Expose
private String sName;

public String getSid() {
return sid;
}

public void setSid(String sid) {
this.sid = sid;
}

public String getSName() {
return sName;
}

public void setSName(String sName) {
this.sName = sName;
}

}
