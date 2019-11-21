package models.ATV;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EPGSlotIdRequestModel {

    @SerializedName("epgSlotIdList")
    @Expose
    private List<String> epgSlotIdList = null;

    public List<String> getEpgSlotIdList() {
        return epgSlotIdList;
    }

    public void setEpgSlotIdList(List<String> epgSlotIdList) {
        this.epgSlotIdList = epgSlotIdList;
    }

}