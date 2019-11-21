package models.ott_frontend.response.Search.KidsCatchUpSearh;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class KidsCatchUp {



        @SerializedName("data")
        @Expose
        private KidsCatchUpSearchdata data;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("code")
        @Expose
        private Integer code;

        public KidsCatchUpSearchdata getData() {
            return data;
        }

        public void setData(KidsCatchUpSearchdata data) {
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


