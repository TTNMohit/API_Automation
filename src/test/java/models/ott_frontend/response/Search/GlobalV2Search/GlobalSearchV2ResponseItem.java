package models.ott_frontend.response.Search.GlobalV2Search;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class    GlobalSearchV2ResponseItem {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("sectionType")
        @Expose
        private String sectionType;
        @SerializedName("layoutType")
        @Expose
        private String layoutType;
        @SerializedName("contentResults")
        @Expose
        private List<GlobalSearchV2ResponseContentResult> contentResults = null;
        @SerializedName("totalCount")
        @Expose
        private Integer totalCount;
        @SerializedName("offset")
        @Expose
        private Integer offset;
        @SerializedName("size")
        @Expose
        private Integer size;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSectionType() {
            return sectionType;
        }

        public void setSectionType(String sectionType) {
            this.sectionType = sectionType;
        }

        public String getLayoutType() {
            return layoutType;
        }

        public void setLayoutType(String layoutType) {
            this.layoutType = layoutType;
        }

        public List<GlobalSearchV2ResponseContentResult> getContentResults() {
            return contentResults;
        }

        public void setContentResults(List<GlobalSearchV2ResponseContentResult> contentResults) {
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




