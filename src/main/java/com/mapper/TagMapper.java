package com.mapper;

import java.util.List;

import com.entity.Tag;

public interface TagMapper {

	/**
	 * 从数据库获取并列出所有标签
	 * 
	 * @return
	 */
	List<Tag> listTag();
}
