package com.service;

import java.util.List;

import com.entity.Comment;

public interface CommentService {
	/**
	 * ��̨��ҳ�е�������������б�
	 * 
	 * @param n �������������
	 * @return
	 */
	public List<Comment> listRecentComment(Integer n);
}
