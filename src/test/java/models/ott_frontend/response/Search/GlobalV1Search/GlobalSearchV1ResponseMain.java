package models.ott_frontend.response.Search.GlobalV1Search;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GlobalSearchV1ResponseMain {

        @SerializedName("data")
        @Expose
        private GlobalV1SearchData data;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("code")
        @Expose
        private Integer code;

        public GlobalV1SearchData getData() {
            return data;
        }

        public void setData(GlobalV1SearchData data) {
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

