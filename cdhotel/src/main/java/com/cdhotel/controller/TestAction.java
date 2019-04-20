package com.cdhotel.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdhotel.common.MD5Util;
import com.cdhotel.mapper.UserMapper;
import com.cdhotel.model.User;

@Controller
public class TestAction {

	@Resource
	private UserMapper userMapper;
	
	@RequestMapping("/save")
	@ResponseBody
	public int save() {
		User user = new User();
		user.setName("TOME");
		String password = MD5Util.string2MD5("123456");
		user.setPassword(password);
		user.setRole("0");
		user.setCreatename("admin");
		user.setEmolument("0");
		return userMapper.insertSelective(user);
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public User getById() {
		return userMapper.selectByPrimaryKey(1);
	}
	
}
