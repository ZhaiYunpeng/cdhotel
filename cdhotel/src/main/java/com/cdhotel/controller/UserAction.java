package com.cdhotel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdhotel.common.MD5Util;
import com.cdhotel.mapper.UserMapper;
import com.cdhotel.model.User;

@Controller
@RequestMapping("/users")
public class UserAction {
	@Autowired
	private UserMapper userMapper;
	/**登录
	 * @return
	 */
	
	@RequestMapping("/login")
	public Map login(String username,String password,String role){
		Map map = new HashMap<>();
		System.out.println(role);
		User user = userMapper.getUser(username);
		//判断密码是否正确
		if(user.getPassword().equals(MD5Util.string2MD5(password))){
			//判断角色是否相同
			if(!user.getRole().equals(role)){
				map.put("code", 1);
				return map;
			}else{
				map.put("code", 0);
				map.put("role", role);
				return map;
			}
		}
		return null;
		
		
	}
	
	/**
	 * 验证该用户是否存在
	 */
	@RequestMapping("/checkusername")
	public String checkUsername(HttpServletRequest req,HttpServletResponse resp){
		try{
			// 接收参数:
			String username = req.getParameter("username");
			// 调用业务层:
			String userName=userMapper.getUserName(username);
			if(userName == null){
				// 用户名可以使用:
				resp.getWriter().println("1");
			}else{
				// 用户名已经存在:
				resp.getWriter().println("2");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		return null;
	}
	/**用户注册
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(HttpServletRequest request,HttpServletResponse response){
		Date now = new Date(); 
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
    	String datetime = dateFormat.format( now ); 
		//用户名
		String username = request.getParameter("username");
		//密码
		String password = request.getParameter("password");
		//确认密码
		String repassword = request.getParameter("repassword");
		String role = "客户";
		String userName=userMapper.getUserName(username);
		if(username.equals(userName)){
			request.setAttribute("msg", "用户名已存在,请重新输入");
		}else{
			if(password.equals(repassword)){
				userMapper.insertUser(username, MD5Util.string2MD5(password),role,datetime);
			}else{
				request.setAttribute("msg", "两次密码不一致");
				//return "redirect:register.jsp";
			}
			
		}
		//[/WEB-INF/jsp/注册成功.html]
		return "index";
		
	}

}
