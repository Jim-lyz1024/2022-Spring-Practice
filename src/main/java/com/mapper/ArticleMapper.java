package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Article;

public interface ArticleMapper {
	/**
	 * ��̨��ҳ�е�������������б�
	 * 
	 * @param n ָ����ʾ����������
	 * @return
	 */
	public List<Article> listRecentArticle(Integer n);

	/**
	 * ����id��ѯ������Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public Article getArticleById(Integer id);

	/**
	 * ��ȫ�����¡�ҳ�棬��ѯ��������
	 * 
	 * @return
	 */
	public List<Article> findAll();

	/**
	 * �������
	 * 
	 * @param article
	 */
	public void addArticle(Article article);

	/**
	 * ������ºͷ���Ĺ���
	 * 
	 * @param articleId  ����ID
	 * @param categoryId ����ID
	 */
	void addArticleCategory(@Param("articleId") Integer articleId, @Param("categoryId") Integer categoryId);

	/**
	 * ������ºͱ�ǩ�Ĺ���
	 * 
	 * @param articleId ����ID
	 * @param tagId     ��ǩID
	 */
	void addArticleTag(@Param("articleId") Integer articleId, @Param("tagId") Integer tagId);

}
