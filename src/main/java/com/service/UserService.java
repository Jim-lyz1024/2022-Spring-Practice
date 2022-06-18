package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {

	/**
	 * 用户登录验证
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	public User login(String userName, String userPass);

	/**
	 * 添加后台用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 显示用户列表
	 * 
	 * @return
	 */
	public List<User> listUser();

	/**
	 * 通过ID来查询用户
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);

	/**
	 * 通过ID更新用户信息
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 通过ID来删除用户
	 * 
	 * @param id
	 */
	public void delUserById(Integer id);

}
