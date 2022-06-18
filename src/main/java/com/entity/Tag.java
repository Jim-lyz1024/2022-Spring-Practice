package com.entity;

public class Tag {
	private Integer tagId;
	private String tagName;
	private String tagDescription;

	// ��������(�������ݿ��ֶ�)
	private Integer articleCount;

	public Tag() {
	}

	public Tag(Integer tagId) {
		this.tagId = tagId;
	}

	public Tag(Integer tagId, String tagName, String tagDescription, Integer articleCount) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagDescription = tagDescription;
		this.articleCount = articleCount;
	}

	public Integer getTagId() {
		return tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public String getTagDescription() {
		return tagDescription;
	}

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
}