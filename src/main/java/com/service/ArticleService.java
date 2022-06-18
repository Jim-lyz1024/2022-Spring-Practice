package com.service;

import java.util.List;

import com.entity.Article;
import com.github.pagehelper.PageInfo;

public interface ArticleService {
	/**
	 * 后台首页中的最近发布文章列表
	 * 
	 * @param n 指定显示的文章数量
	 * @return
	 */
	public List<Article> listRecentArticle(Integer n);

	/**
	 * “全部文章”页面，查询所有文章
	 * 
	 * @return
	 */
	public List<Article> findAll();

	/**
	 * 分页查询文章列表
	 * 
	 * @param pageIndex 从第几页开始（起始页页码）
	 * @param pageSize  每页多少条数据
	 * @return 文章列表数据，并用PageInfo进行包装
	 */
	public PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize);

	/**
	 * 添加文章
	 * 
	 * @param article
	 */
	public void addArticle(Article article);
}
