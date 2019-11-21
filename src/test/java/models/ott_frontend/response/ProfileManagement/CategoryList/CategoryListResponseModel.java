package models.ott_frontend.response.ProfileManagement.CategoryList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryListResponseModel {

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("data")
        @Expose
        private List<CatergoryListResponseDataModel> data = null;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<CatergoryListResponseDataModel> getData() {
            return data;
        }

        public void setData(List<CatergoryListResponseDataModel> data) {
            this.data = data;
        }

    }

