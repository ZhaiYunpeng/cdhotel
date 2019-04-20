/**
 * 
 */
package com.cdhotel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdhotel.mapper.UserMapper;
import com.cdhotel.model.User;
import com.cdhotel.service.UserService;

/**
 * @author 
 *	用户Service
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public boolean nameIsExist(String username) {
		return userMapper.getNumByUsername(username) > 0;
	}

	@Override
	public boolean userIsExist(String username, String password) {
		System.out.println(userMapper.userIsExist(username, password));
		return userMapper.userIsExist(username, password) > 0;
	}

	@Override
	public boolean register(User user) {
		return userMapper.insertSelective(user) > 0;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
