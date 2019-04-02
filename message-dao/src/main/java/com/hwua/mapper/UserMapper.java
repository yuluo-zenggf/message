package com.hwua.mapper;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hwua.entity.User;

@Repository("userMapper")
public interface UserMapper {
	/**
	 * 根据用户信息查询用户
	 * 
	 * @param user 用户
	 * @return 查询到的用户
	 * @throws SQLException
	 */
	public User queryByUser(User user) throws SQLException;

	/***
	 * 保存用户
	 * 
	 * @param user 用户
	 * @return 影响数据库的行数
	 * @throws SQLException
	 */
	public int save(User user) throws SQLException;

	/**
	 * 查询所有的用户
	 * 
	 * @return 用户的list
	 * @throws SQLException
	 */
	public List<User> queryAllUsers() throws SQLException;

	/**
	 * 根据发送者id查询用户
	 * 
	 * @param sendid 发送者id
	 * @return 查询到的用户
	 * @throws SQLException
	 */
	public User queryBySendid(int sendid) throws SQLException;

	/**
	 * 根据用户名查询用户
	 * 
	 * @param name 用户名
	 * @return 查询到的用户
	 * @throws SQLException
	 */
	public User queryByName(String name) throws SQLException;
}
