
package com.cdhotel.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdhotel.service.UserService;
import com.cdhotel.websocket.WebSocketTest;

/**
 *
 */
@Controller
public class CommonController {

	private final UserService userService;

	@Autowired
	public CommonController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/")
	public String index(){
		return "index";
	}


	@RequestMapping("/websocket")
	public String websocket(){
		return "webSocket";
	}
	@RequestMapping("/websocket1")
	public String websocket1(){
		return "webSocket1";
	}



	@RequestMapping("getJSP")
	public String JSPTest() {
		new WebSocketTest().sendAll("rtest");
		return null;
	}

//	@RequestMapping("userTest")
//	public User getUser() {
//		int i = 0;
//		User user = null;
//		long startTime = System.currentTimeMillis();
//		int numberOfQueries = 10000;
//		while (i < numberOfQueries) {
//			user = userService.getUserByID(1);
//			i++;
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime + "ms");
//		return user;
//	}
}
