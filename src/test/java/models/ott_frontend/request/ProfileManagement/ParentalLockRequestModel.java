package models.ott_frontend.request.ProfileManagement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentalLockRequestModel {
        @SerializedName("parentalLock")
        @Expose
        private String parentalLock;

        public String getParentalLock() {
            return parentalLock;
        }

        public void setParentalLock(String parentalLock) {
            this.parentalLock = parentalLock;
        }

    }



