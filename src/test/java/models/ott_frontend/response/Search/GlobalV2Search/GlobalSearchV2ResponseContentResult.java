package models.ott_frontend.response.Search.GlobalV2Search;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalSearchV2ResponseContentResult {



        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("contentType")
        @Expose
        private String contentType;
        @SerializedName("subTitles")
        @Expose
        private List<String> subTitles = null;
        @SerializedName("position")
        @Expose
        private Integer position;
        @SerializedName("logo")
        @Expose
        private String logo;
        @SerializedName("airedDate")
        @Expose
        private Long airedDate;
        @SerializedName("contractName")
        @Expose
        private String contractName;
        @SerializedName("entitlements")
        @Expose
        private List<String> entitlements = null;
        @SerializedName("epgState")
        @Expose
        private String epgState;
        @SerializedName("channelId")
        @Expose
        private Integer channelId;
        @SerializedName("provider")
        @Expose
        private String provider;
        @SerializedName("channelOtt")
        @Expose
        private Boolean channelOtt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public List<String> getSubTitles() {
            return subTitles;
        }

        public void setSubTitles(List<String> subTitles) {
            this.subTitles = subTitles;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public Long getAiredDate() {
            return airedDate;
        }

        public void setAiredDate(Long airedDate) {
            this.airedDate = airedDate;
        }

        public String getContractName() {
            return contractName;
        }

        public void setContractName(String contractName) {
            this.contractName = contractName;
        }

        public List<String> getEntitlements() {
            return entitlements;
        }

        public void setEntitlements(List<String> entitlements) {
            this.entitlements = entitlements;
        }

        public String getEpgState() {
            return epgState;
        }

        public void setEpgState(String epgState) {
            this.epgState = epgState;
        }

        public Integer getChannelId() {
            return channelId;
        }

        public void setChannelId(Integer channelId) {
            this.channelId = channelId;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public Boolean getChannelOtt() {
            return channelOtt;
        }

        public void setChannelOtt(Boolean channelOtt) {
            this.channelOtt = channelOtt;
        }

    }

