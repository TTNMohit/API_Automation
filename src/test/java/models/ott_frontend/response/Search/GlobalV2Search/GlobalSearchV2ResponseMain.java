package models.ott_frontend.response.Search.GlobalV2Search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalSearchV2ResponseMain {

        @SerializedName("data")
        @Expose
        private GlobalSearchV2ResponseData data;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("code")
        @Expose
        private Integer code;

        public GlobalSearchV2ResponseData getData() {
            return data;
        }

        public void setData(GlobalSearchV2ResponseData data) {
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

