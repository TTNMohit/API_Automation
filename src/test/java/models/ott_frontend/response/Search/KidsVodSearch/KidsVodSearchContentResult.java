package models.ott_frontend.response.Search.KidsVodSearch;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KidsVodSearchContentResult {


        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("genres")
        @Expose
        private List<String> genres = null;
        @SerializedName("contentType")
        @Expose
        private String contentType;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("contractName")
        @Expose
        private String contractName;
        @SerializedName("entitlements")
        @Expose
        private List<String> entitlements = null;
        @SerializedName("languages")
        @Expose
        private List<String> languages = null;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("provider")
        @Expose
        private String provider;
        @SerializedName("providerContentId")
        @Expose
        private String providerContentId;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public List<String> getLanguages() {
            return languages;
        }

        public void setLanguages(List<String> languages) {
            this.languages = languages;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public String getProviderContentId() {
            return providerContentId;
        }

        public void setProviderContentId(String providerContentId) {
            this.providerContentId = providerContentId;
        }

    }

