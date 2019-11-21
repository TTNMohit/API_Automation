package models.ott_frontend.response.Fifa_Pojo.FIFA_Config_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Url {

    @SerializedName("selfCareSignUpUrl")
    @Expose
    private String selfCareSignUpUrl;
    @SerializedName("eulaUrl")
    @Expose
    private String eulaUrl;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("helpUrl")
    @Expose
    private String helpUrl;
    @SerializedName("termsConditionsUrl")
    @Expose
    private String termsConditionsUrl;
    @SerializedName("privacyPolicyUrl")
    @Expose
    private String privacyPolicyUrl;

    public String getSelfCareSignUpUrl() {
        return selfCareSignUpUrl;
    }

    public void setSelfCareSignUpUrl(String selfCareSignUpUrl) {
        this.selfCareSignUpUrl = selfCareSignUpUrl;
    }

    public String getEulaUrl() {
        return eulaUrl;
    }

    public void setEulaUrl(String eulaUrl) {
        this.eulaUrl = eulaUrl;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getHelpUrl() {
        return helpUrl;
    }

    public void setHelpUrl(String helpUrl) {
        this.helpUrl = helpUrl;
    }

    public String getTermsConditionsUrl() {
        return termsConditionsUrl;
    }

    public void setTermsConditionsUrl(String termsConditionsUrl) {
        this.termsConditionsUrl = termsConditionsUrl;
    }

    public String getPrivacyPolicyUrl() {
        return privacyPolicyUrl;
    }

    public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
        this.privacyPolicyUrl = privacyPolicyUrl;
    }

}
