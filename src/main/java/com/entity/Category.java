package com.entity;

public class Category {
	// ���������ID
	private Integer categoryId;

	// ����ĸ���id
	private Integer categoryPid;

	// ��������
	private String categoryName;

	// ��������
	private String categoryDescription;

	// �����˳��
	private Integer categoryOrder;

	// �����ͼ��
	private String categoryIcon;

	// ��������(�����ݿ��ֶ�)
	private Integer articleCount;

	public Integer getCategoryId() {
		return categoryId;
	}

	public Category() {
	}

	public Category(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryPid() {
		return categoryPid;
	}

	public void setCategoryPid(Integer categoryPid) {
		this.categoryPid = categoryPid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Integer getCategoryOrder() {
		return categoryOrder;
	}

	public void setCategoryOrder(Integer categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

	public String getCategoryIcon() {
		return categoryIcon;
	}

	public void setCategoryIcon(String categoryIcon) {
		this.categoryIcon = categoryIcon;
	}

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryPid=" + categoryPid + ", categoryName=" + categoryName
				+ ", categoryDescription=" + categoryDescription + ", categoryOrder=" + categoryOrder
				+ ", categoryIcon=" + categoryIcon + ", articleCount=" + articleCount + "]";
	}

}