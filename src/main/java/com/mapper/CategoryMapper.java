package com.mapper;

import java.util.List;

import com.entity.Category;

public interface CategoryMapper {
	/**
	 * ��������id,��ѯ���¶�Ӧ����Щ����
	 * 
	 * @param articleId ����id
	 * @return �����б�(ʵ����ֻ����������,��������,�Ӽ�����)
	 */
	List<Category> listCategoryByArticleId(Integer articleId);

	/**
	 * ��ȡ���µ�ȫ����������
	 * 
	 * @return
	 */
	List<Category> listCategory();

}
