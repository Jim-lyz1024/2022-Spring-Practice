package com.service;

import java.util.List;

import com.entity.Category;

public interface CategoryService {
	/**
	 * 获取文章的全部可能类型
	 * 
	 * @return
	 */
	List<Category> listCategory();
}
