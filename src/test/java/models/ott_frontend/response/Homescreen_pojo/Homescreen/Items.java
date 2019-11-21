package models.ott_frontend.response.Homescreen_pojo.Homescreen;



public class Items {
	private String position;

	private String id;

	private String specialRail;

	private String title;

	private String configType;

	private String autoScroll;

	private String totalCount;

	private ContentList[] contentList;

	private String sectionType;

	private String layoutType;

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

	public String getSpecialRail() {
		return specialRail;
	}

	public void setSpecialRail(String specialRail) {
		this.specialRail = specialRail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConfigType() {
		return configType;
	}

	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public String getAutoScroll() {
		return autoScroll;
	}

	public void setAutoScroll(String autoScroll) {
		this.autoScroll = autoScroll;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public ContentList[] getContentList() {
		return contentList;
	}

	public void setContentList(ContentList[] contentList) {
		this.contentList = contentList;
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

	@Override
	public String toString() {
		return "ClassPojo [position = " + position + ", id = " + id
				+ ", specialRail = " + specialRail + ", title = " + title
				+ ", configType = " + configType + ", autoScroll = "
				+ autoScroll + ", totalCount = " + totalCount
				+ ", contentList = " + contentList + ", sectionType = "
				+ sectionType + ", layoutType = " + layoutType + "]";
	}
}
