package models.ott_frontend.response.Search.GlobalV2Search;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalSearchV2ResponseData {

        @SerializedName("items")
        @Expose
        private List<GlobalSearchV2ResponseItem> items = null;
        @SerializedName("noResultSuggestions")
        @Expose
        private List<Object> noResultSuggestions = null;
        @SerializedName("availableShowTypes")
        @Expose
        private List<String> availableShowTypes = null;

        public List<GlobalSearchV2ResponseItem> getItems() {
            return items;
        }

        public void setItems(List<GlobalSearchV2ResponseItem> items) {
            this.items = items;
        }

        public List<Object> getNoResultSuggestions() {
            return noResultSuggestions;
        }

        public void setNoResultSuggestions(List<Object> noResultSuggestions) {
            this.noResultSuggestions = noResultSuggestions;
        }

        public List<String> getAvailableShowTypes() {
            return availableShowTypes;
        }

        public void setAvailableShowTypes(List<String> availableShowTypes) {
            this.availableShowTypes = availableShowTypes;
        }

    }

