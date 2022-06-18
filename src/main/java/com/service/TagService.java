package com.service;

import java.util.List;

import com.entity.Tag;

public interface TagService {
	/**
	 * 从数据库获取并列出所有标签
	 * 
	 * @return
	 */
	List<Tag> listTag();
}
