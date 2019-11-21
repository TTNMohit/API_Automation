package models.ott_frontend.response.Search.GlobalV1Search;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalV1SearchContentResult {

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

    }

