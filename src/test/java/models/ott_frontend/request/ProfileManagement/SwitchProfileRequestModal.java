package models.ott_frontend.request.ProfileManagement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class SwitchProfileRequestModal {

        @SerializedName("isDefaultProfile")
        @Expose
        private Boolean isDefaultProfile;

        public Boolean getIsDefaultProfile() {
            return isDefaultProfile;
        }

        public void setIsDefaultProfile(Boolean isDefaultProfile) {
            this.isDefaultProfile = isDefaultProfile;
        }

    }

