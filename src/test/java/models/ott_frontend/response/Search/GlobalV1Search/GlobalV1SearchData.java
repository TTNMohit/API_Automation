package models.ott_frontend.response.Search.GlobalV1Search;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalV1SearchData {

        @SerializedName("liveContentResults")
        @Expose
        private GlobalV1SearchLiveContentResults liveContentResults;
        @SerializedName("onDemandContentResults")
        @Expose
        private GlobalV1SearchOnDemandContentResults onDemandContentResults;
        @SerializedName("channelContentResults")
        @Expose
        private GlobalV1SearchChannelContentResults channelContentResults;
        @SerializedName("noResultSuggestions")
        @Expose
        private List<Object> noResultSuggestions = null;
        @SerializedName("availableShowTypes")
        @Expose
        private List<String> availableShowTypes = null;

        public GlobalV1SearchLiveContentResults getLiveContentResults() {
            return liveContentResults;
        }

        public void setLiveContentResults(GlobalV1SearchLiveContentResults liveContentResults) {
            this.liveContentResults = liveContentResults;
        }

        public GlobalV1SearchOnDemandContentResults getOnDemandContentResults() {
            return onDemandContentResults;
        }

        public void setOnDemandContentResults(GlobalV1SearchOnDemandContentResults onDemandContentResults) {
            this.onDemandContentResults = onDemandContentResults;
        }

        public GlobalV1SearchChannelContentResults getChannelContentResults() {
            return channelContentResults;
        }

        public void setChannelContentResults(GlobalV1SearchChannelContentResults channelContentResults) {
            this.channelContentResults = channelContentResults;
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

