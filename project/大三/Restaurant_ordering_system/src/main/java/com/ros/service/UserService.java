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
	 * ��֤�û��Ƿ����
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
	 * ����һ���û�����
	 */

	public boolean insertUser(User user) {
		if (userMapper.insertSelective(user) == 1) {
			return true;
		} else {
			return false;
		}

	}
	/*
	 * �����û�����id
	 */

	public int getUserId(String username) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
		List<User> users = userMapper.selectByExample(example);
		return users.get(0).getUserId();
		
	}

	
	/*
	 * �޸�һ���û�����
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
	 * ��ѯ�����û���Ϣ
	 */
	
	public List<User> getAllUser() {
		List<User> users = userMapper.selectByExample(null);
		return users;
	}
	
	/*
	 * ͨ��Id��ѯ�����û���Ϣ
	 */
	
	public User getUserbyID(int userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}
	
	
	/*
	 * ɾ��һ���û���Ϣ
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
	 * ����û����Ƿ����
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
