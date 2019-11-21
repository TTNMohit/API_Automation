package models.ott_frontend.response.Search.GlobalV1Search;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalV1SearchLiveContentResults {

        @SerializedName("contentResults")
        @Expose
        private List<GlobalV1SearchContentResult1> contentResults = null;
        @SerializedName("totalCount")
        @Expose
        private Integer totalCount;
        @SerializedName("offset")
        @Expose
        private Integer offset;
        @SerializedName("size")
        @Expose
        private Integer size;

        public List<GlobalV1SearchContentResult1> getContentResults() {
            return contentResults;
        }

        public void setContentResults(List<GlobalV1SearchContentResult1> contentResults) {
            this.contentResults = contentResults;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

    }


