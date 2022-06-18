package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {

	/**
	 * �û���¼��֤
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	public User login(String userName, String userPass);

	/**
	 * ��Ӻ�̨�û�
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * ��ʾ�û��б�
	 * 
	 * @return
	 */
	public List<User> listUser();

	/**
	 * ͨ��ID����ѯ�û�
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);

	/**
	 * ͨ��ID�����û���Ϣ
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * ͨ��ID��ɾ���û�
	 * 
	 * @param id
	 */
	public void delUserById(Integer id);

}
