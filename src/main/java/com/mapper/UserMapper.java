package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.User;

public interface UserMapper {
	/**
	 * 用户登录验证
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	public User login(@Param("userName") String userName, @Param("userPass") String userPass);

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
