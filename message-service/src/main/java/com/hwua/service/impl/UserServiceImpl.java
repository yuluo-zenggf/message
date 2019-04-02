package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hwua.entity.User;
import com.hwua.mapper.UserMapper;
import com.hwua.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource(name = "userMapper")
	private UserMapper userDao;

	@Override
	public User login(User user) {
		try {
			user = userDao.queryByUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean register(User user) {
		int res = 0;
		try {
			res = userDao.save(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res > 0 ? true : false;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> uList = null;
		try {
			uList = userDao.queryAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uList;
	}

	@Override
	public User queryUserBySendid(int sendid) {
		User user = null;
		try {
			user = userDao.queryBySendid(sendid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean queryUserByName(String name) {
		User user = null;
		try {
			user = userDao.queryByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user == null ? false : true;
	}
}
