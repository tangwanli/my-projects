package com.ros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ros.bean.User;
import com.ros.bean.UserExample;
import com.ros.bean.UserExample.Criteria;
import com.ros.dao.UserMapper;

@Service
public class UserService {

	/*
	 * 验证用户是否存在
	 */
	@Autowired
	private UserMapper userMapper;

	public boolean checkUser(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(user.getUserName()).andUserPasswordEqualTo(user.getUserPassword());
		List<User> users = userMapper.selectByExample(example);
		if (users.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}
	/*
	 * 插入一条用户数据
	 */

	public boolean insertUser(User user) {
		if (userMapper.insertSelective(user) == 1) {
			return true;
		} else {
			return false;
		}

	}
	/*
	 * 根据用户名查id
	 */

	public int getUserId(String username) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
		List<User> users = userMapper.selectByExample(example);
		return users.get(0).getUserId();
		
	}

	
	/*
	 * 修改一条用户数据
	 */
	
	public boolean update(User user) {
		if(userMapper.updateByPrimaryKeySelective(user)==1) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	/*
	 * 查询所有用户信息
	 */
	
	public List<User> getAllUser() {
		List<User> users = userMapper.selectByExample(null);
		return users;
	}
	
	/*
	 * 通过Id查询单个用户信息
	 */
	
	public User getUserbyID(int userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}
	
	
	/*
	 * 删除一条用户信息
	 */
	
	public boolean deleteUser(int userId) {
		if(userMapper.deleteByPrimaryKey(userId)==1) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	/*
	 * 检查用户名是否存在
	 */
	public boolean existUser(String name) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(name);
		List<User> users = userMapper.selectByExample(example);
		if (users.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}
}
