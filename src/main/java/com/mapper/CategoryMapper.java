package com.mapper;

import java.util.List;

import com.entity.Category;

public interface CategoryMapper {
	/**
	 * 根据文章id,查询文章对应着哪些分类
	 * 
	 * @param articleId 文章id
	 * @return 分类列表(实际上只有两条数据,父级分类,子级分类)
	 */
	List<Category> listCategoryByArticleId(Integer articleId);

	/**
	 * 获取文章的全部可能类型
	 * 
	 * @return
	 */
	List<Category> listCategory();

}
