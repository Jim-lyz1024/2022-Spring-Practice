package com.mapper;

import java.util.List;

import com.entity.Comment;

public interface CommentMapper {
	/**
	 * ��̨��ҳ�е�������������б�
	 * 
	 * @param n �������������
	 * @return
	 */
	public List<Comment> listRecentComment(Integer n);
}
