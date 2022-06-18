package com.entity;

import java.util.Date;

public class Comment {
	// 自增id
	private Integer commentId;

	// 评论的父级ID( 或评论人的ID? )
	private Integer commentPid;

	// 评论人的名称
	private String commentPname;

	// 被评论的文章的ID
	private Integer commentArticleId;

	// 评论者名称
	private String commentAuthorName;

	// 评论者邮箱
	private String commentAuthorEmail;

	// 评论者的网址
	private String commentAuthorUrl;

	// 评论者的头象地址
	private String commentAuthorAvatar;

	// 评论的内容
	private String commentContent;

	// 评论人的代理服务器
	private String commentAgent;

	// 评论人的IP
	private String commentIp;

	// 论评创建的时间
	private Date commentCreateTime;

	// 论评人的角色(管理员 1, 访客 0)
	private Integer commentRole;

	// 被评论的文章是哪个 非数据库字段
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
