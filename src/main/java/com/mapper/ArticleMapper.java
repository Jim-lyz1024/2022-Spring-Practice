package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Article;

public interface ArticleMapper {
	/**
	 * 后台首页中的最近发布文章列表
	 * 
	 * @param n 指定显示的文章数量
	 * @return
	 */
	public List<Article> listRecentArticle(Integer n);

	/**
	 * 根据id查询文章信息
	 * 
	 * @param id
	 * @return
	 */
	public Article getArticleById(Integer id);

	/**
	 * “全部文章”页面，查询所有文章
	 * 
	 * @return
	 */
	public List<Article> findAll();

	/**
	 * 添加文章
	 * 
	 * @param article
	 */
	public void addArticle(Article article);

	/**
	 * 添加文章和分类的关联
	 * 
	 * @param articleId  文章ID
	 * @param categoryId 分类ID
	 */
	void addArticleCategory(@Param("articleId") Integer articleId, @Param("categoryId") Integer categoryId);

	/**
	 * 添加文章和标签的关联
	 * 
	 * @param articleId 文章ID
	 * @param tagId     标签ID
	 */
	void addArticleTag(@Param("articleId") Integer articleId, @Param("tagId") Integer tagId);

}
