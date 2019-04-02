package com.hwua.service;

import java.util.List;

import com.hwua.entity.User;

/**
 * 
 * @author Administrator
 *
 */
public interface IUserService {
	/**
	 * 登录功能
	 * 
	 * @param user 登录的用户
	 * @return 登录成功的用户
	 */
	public User login(User user);// 登录

	/**
	 * 注册功能
	 * 
	 * @param user 注册的用户信息
	 * @return 是否注册成功
	 */
	public boolean register(User user);// 注册

	/**
	 * 获取所有的用户
	 * 
	 * @return 用户的list
	 */
	public List<User> getAllUsers();

	/**
	 * 通过发送者id查询用户信息
	 * 
	 * @param sendid 发送者id
	 * @return 用户信息
	 */
	public User queryUserBySendid(int sendid);

	/**
	 * 通过用户名查询用户
	 * 
	 * @param name 用户名
	 * @return 是否查到该用户
	 */
	public boolean queryUserByName(String name);

}
