package com.cdhotel.controller.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdhotel.common.MD5Util;
import com.cdhotel.mapper.UserMapper;

/**
 *
 */
@Controller
public class LoginController {

	private final UserMapper userMapper;

    @Autowired
    public LoginController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

//	@RequestMapping(value = "/")
//	public String index(Model model, HttpServletResponse response) {
//		model.addAttribute("name", "simonsfan");
//		return "index";
//	}

	@RequestMapping(value = "/notLogin")
	public String notLogin() {
		return "notLogin";
	}

	@RequestMapping(value = "/notRole")
	public String notRole() {
		return "notRole";
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			// 注销
			subject.logout();
		}
		return "logout";
	}

	/**
	 *  登陆
	 *
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value = "/login")
    @ResponseBody
	public String login(String username, String password) {
		password = MD5Util.string2MD5(password); 
		// 从SecurityUtils里边创建一个 subject
		Subject subject = SecurityUtils.getSubject();
		// 在认证提交前准备 token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// 执行认证登陆
		subject.login(token);
		// 根据权限，指定返回数据
		String role = userMapper.getRolenameByUserame(username);
		if (role != null){
			return username+"欢迎登录,你的角色为"+role;
		}
		return "权限错误！";
	}
}
