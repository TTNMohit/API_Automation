package models.ott_frontend.response.Search.KidsChannelSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KidsChannel {



        @SerializedName("data")
        @Expose
        private KidsChannelSearchData data;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("code")
        @Expose
        private Integer code;

        public KidsChannelSearchData getData() {
            return data;
        }

        public void setData(KidsChannelSearchData data) {
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
