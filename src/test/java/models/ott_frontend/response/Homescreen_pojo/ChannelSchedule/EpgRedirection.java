package models.ott_frontend.response.Homescreen_pojo.ChannelSchedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EpgRedirection {

    @SerializedName("hotstarEpisodeId")
    @Expose
    private String hotstarEpisodeId;
    @SerializedName("hotstarProgramId")
    @Expose
    private String hotstarProgramId;

    public String getHotstarEpisodeId() {
        return hotstarEpisodeId;
    }

    public void setHotstarEpisodeId(String hotstarEpisodeId) {
        this.hotstarEpisodeId = hotstarEpisodeId;
    }

    public String getHotstarProgramId() {
        return hotstarProgramId;
    }

    public void setHotstarProgramId(String hotstarProgramId) {
        this.hotstarProgramId = hotstarProgramId;
    }

}
