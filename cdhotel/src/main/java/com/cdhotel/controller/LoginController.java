/**
 * 
 */
package com.cdhotel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdhotel.common.MD5Util;
import com.cdhotel.common.SystemCommon;
import com.cdhotel.service.UserService;

/**
 * @author 
 *	登录用controller
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userServie;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("login")
	public String login(String username,String password) {
		password = MD5Util.string2MD5(password); 
		boolean userIsExist = userServie.userIsExist(username, password);
		System.out.println(userIsExist);
		return SystemCommon.returnJson(String.valueOf(userIsExist).toUpperCase(), "登录成功", "");
	}
}
