package com.entity;

import java.util.Date;

public class Comment {
	// ����id
	private Integer commentId;

	// ���۵ĸ���ID( �������˵�ID? )
	private Integer commentPid;

	// �����˵�����
	private String commentPname;

	// �����۵����µ�ID
	private Integer commentArticleId;

	// ����������
	private String commentAuthorName;

	// ����������
	private String commentAuthorEmail;

	// �����ߵ���ַ
	private String commentAuthorUrl;

	// �����ߵ�ͷ���ַ
	private String commentAuthorAvatar;

	// ���۵�����
	private String commentContent;

	// �����˵Ĵ��������
	private String commentAgent;

	// �����˵�IP
	private String commentIp;

	// ����������ʱ��
	private Date commentCreateTime;

	// �����˵Ľ�ɫ(����Ա 1, �ÿ� 0)
	private Integer commentRole;

	// �����۵��������ĸ� �����ݿ��ֶ�
	private Article article;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getCommentPid() {
		return commentPid;
	}

	public void setCommentPid(Integer commentPid) {
		this.commentPid = commentPid;
	}

	public String getCommentPname() {
		return commentPname;
	}

	public void setCommentPname(String commentPname) {
		this.commentPname = commentPname;
	}

	public Integer getCommentArticleId() {
		return commentArticleId;
	}

	public void setCommentArticleId(Integer commentArticleId) {
		this.commentArticleId = commentArticleId;
	}

	public String getCommentAuthorName() {
		return commentAuthorName;
	}

	public void setCommentAuthorName(String commentAuthorName) {
		this.commentAuthorName = commentAuthorName;
	}

	public String getCommentAuthorEmail() {
		return commentAuthorEmail;
	}

	public void setCommentAuthorEmail(String commentAuthorEmail) {
		this.commentAuthorEmail = commentAuthorEmail;
	}

	public String getCommentAuthorUrl() {
		return commentAuthorUrl;
	}

	public void setCommentAuthorUrl(String commentAuthorUrl) {
		this.commentAuthorUrl = commentAuthorUrl;
	}

	public String getCommentAuthorAvatar() {
		return commentAuthorAvatar;
	}

	public void setCommentAuthorAvatar(String commentAuthorAvatar) {
		this.commentAuthorAvatar = commentAuthorAvatar;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentAgent() {
		return commentAgent;
	}

	public void setCommentAgent(String commentAgent) {
		this.commentAgent = commentAgent;
	}

	public String getCommentIp() {
		return commentIp;
	}

	public void setCommentIp(String commentIp) {
		this.commentIp = commentIp;
	}

	public Date getCommentCreateTime() {
		return commentCreateTime;
	}

	public void setCommentCreateTime(Date commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}

	public Integer getCommentRole() {
		return commentRole;
	}

	public void setCommentRole(Integer commentRole) {
		this.commentRole = commentRole;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentPid=" + commentPid + ", commentPname=" + commentPname
				+ ", commentArticleId=" + commentArticleId + ", commentAuthorName=" + commentAuthorName
				+ ", commentAuthorEmail=" + commentAuthorEmail + ", commentAuthorUrl=" + commentAuthorUrl
				+ ", commentAuthorAvatar=" + commentAuthorAvatar + ", commentContent=" + commentContent
				+ ", commentAgent=" + commentAgent + ", commentIp=" + commentIp + ", commentCreateTime="
				+ commentCreateTime + ", commentRole=" + commentRole + ", article=" + article + "]";
	}

}
