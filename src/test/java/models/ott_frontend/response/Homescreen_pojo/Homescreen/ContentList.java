package models.ott_frontend.response.Homescreen_pojo.Homescreen;



public class ContentList {
	private String[] genre;

	private String position;

	private String id;

	private String[] subTitles;

	private String title;

	private String allowedOnBrowsers;

	private String image;

	private String blackOut;

	private String[] language;

	private String contentType;

	private String contractName;

	private String[] entitlements;

	public String[] getGenre() {
		return genre;
	}

	public void setGenre(String[] genre) {
		this.genre = genre;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getSubTitles() {
		return subTitles;
	}

	public void setSubTitles(String[] subTitles) {
		this.subTitles = subTitles;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAllowedOnBrowsers() {
		return allowedOnBrowsers;
	}

	public void setAllowedOnBrowsers(String allowedOnBrowsers) {
		this.allowedOnBrowsers = allowedOnBrowsers;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBlackOut() {
		return blackOut;
	}

	public void setBlackOut(String blackOut) {
		this.blackOut = blackOut;
	}

	public String[] getLanguage() {
		return language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String[] getEntitlements() {
		return entitlements;
	}

	public void setEntitlements(String[] entitlements) {
		this.entitlements = entitlements;
	}

	@Override
	public String toString() {
		return "ClassPojo [genre = " + genre + ", position = " + position
				+ ", id = " + id + ", subTitles = " + subTitles + ", title = "
				+ title + ", allowedOnBrowsers = " + allowedOnBrowsers
				+ ", image = " + image + ", blackOut = " + blackOut
				+ ", language = " + language + ", contentType = " + contentType
				+ ", contractName = " + contractName + ", entitlements = "
				+ entitlements + "]";
	}
}
