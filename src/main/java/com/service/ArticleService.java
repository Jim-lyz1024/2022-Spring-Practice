package com.service;

import java.util.List;

import com.entity.Article;
import com.github.pagehelper.PageInfo;

public interface ArticleService {
	/**
	 * ��̨��ҳ�е�������������б�
	 * 
	 * @param n ָ����ʾ����������
	 * @return
	 */
	public List<Article> listRecentArticle(Integer n);

	/**
	 * ��ȫ�����¡�ҳ�棬��ѯ��������
	 * 
	 * @return
	 */
	public List<Article> findAll();

	/**
	 * ��ҳ��ѯ�����б�
	 * 
	 * @param pageIndex �ӵڼ�ҳ��ʼ����ʼҳҳ�룩
	 * @param pageSize  ÿҳ����������
	 * @return �����б����ݣ�����PageInfo���а�װ
	 */
	public PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize);

	/**
	 * �������
	 * 
	 * @param article
	 */
	public void addArticle(Article article);
}
