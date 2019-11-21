package models.ott_frontend.response.Search.KidsVodSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KidsVod {

        @SerializedName("data")
        @Expose
        private KidsVodSearchData data;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("code")
        @Expose
        private Integer code;

        public KidsVodSearchData getData() {
            return data;
        }

        public void setData(KidsVodSearchData data) {
            this.data = data;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

    }

