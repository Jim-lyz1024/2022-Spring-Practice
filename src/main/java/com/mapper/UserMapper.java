package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.User;

public interface UserMapper {
	/**
	 * �û���¼��֤
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	public User login(@Param("userName") String userName, @Param("userPass") String userPass);

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
