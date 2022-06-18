package com.mapper;

import java.util.List;

import com.entity.Comment;

public interface CommentMapper {
	/**
	 * 后台首页中的最近发布评论列表
	 * 
	 * @param n 最近发布评论数
	 * @return
	 */
	public List<Comment> listRecentComment(Integer n);
}
