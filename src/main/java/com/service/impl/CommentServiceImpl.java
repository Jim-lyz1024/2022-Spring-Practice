package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Article;
import com.entity.Comment;
import com.mapper.ArticleMapper;
import com.mapper.CommentMapper;
import com.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentMapper commentMapper;

	@Resource
	private ArticleMapper articleMapper;

	@Override
	public List<Comment> listRecentComment(Integer n) {
		// return commentMapper.listRecentComment(n);
		List<Comment> commentList = commentMapper.listRecentComment(n);

		// 将每条评论对应的文章信息查询出来
		for (Comment c : commentList) {
			Article article = articleMapper.getArticleById(c.getCommentArticleId());
			// 为实体类Comment中属性Article赋值
			c.setArticle(article);
		}
		return commentList;
	}

}
