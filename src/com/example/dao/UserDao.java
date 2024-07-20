package com.example.dao;

import com.example.pojo.User;

/**
 * Class name: UserDao Package: com.example.dao.impl Description:UserDao
 *
 * @Author: twl
 * @Create-time: 2024/4/19 - 17:30
 */
public interface UserDao {

	/**
	 * 根据username查询User
	 * 
	 * @param username
	 * @return User
	 */
	User queryUserByUsername(String username);

	/**
	 * 根据username和password查询User
	 * 
	 * @param username
	 * @param password
	 * @return User
	 */
	User queryUserByUsernameAndPassword(String username, String password);

	/**
	 * 保存User
	 * 
	 * @param user
	 * @return 数据库表改动行数
	 */
	int saveUser(User user);
}
