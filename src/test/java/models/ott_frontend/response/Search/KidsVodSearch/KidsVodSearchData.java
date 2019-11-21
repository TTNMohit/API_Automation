package models.ott_frontend.response.Search.KidsVodSearch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KidsVodSearchData {

        @SerializedName("contentResults")
        @Expose
        private List <KidsVodSearchContentResult> contentResults = null;
        @SerializedName("totalCount")
        @Expose
        private Integer totalCount;
        @SerializedName("offset")
        @Expose
        private Integer offset;
        @SerializedName("size")
        @Expose
        private Integer size;

        public List <KidsVodSearchContentResult> getContentResults() {
            return contentResults;
        }

        public void setContentResults(List <KidsVodSearchContentResult> contentResults) {
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


