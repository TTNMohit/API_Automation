package models.ott_frontend.response.LoginManagement.SubscriberLookupWithRmn;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubscriberLookupWithRmnDataResponseModel {

@SerializedName("rmn")
@Expose
private String rmn;
@SerializedName("sidList")
@Expose
private List<SubscriberLookupWithRmnSidListResponseModel> sidList = null;

public String getRmn() {
return rmn;
}

public void setRmn(String rmn) {
this.rmn = rmn;
}

public List<SubscriberLookupWithRmnSidListResponseModel> getSidList() {
return sidList;
}

public void setSidList(List<SubscriberLookupWithRmnSidListResponseModel> sidList) {
this.sidList = sidList;
}

}
