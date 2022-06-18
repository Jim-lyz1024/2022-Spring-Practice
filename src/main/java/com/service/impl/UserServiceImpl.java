package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User login(String userName, String userPass) {
		// TODO Auto-generated method stub

		System.out.println("Service: " + userName + ", " + userPass);
		return userMapper.login(userName, userPass);

	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);

	}

	@Override
	public List<User> listUser() {
		return userMapper.listUser();
	}

	@Override
	public User getUserById(Integer id) {

		return userMapper.getUserById(id);
	}

	@Override
	public void updateUser(User user) {

		userMapper.updateUser(user);

	}

	@Override
	public void delUserById(Integer id) {

		userMapper.delUserById(id);

	}
}
