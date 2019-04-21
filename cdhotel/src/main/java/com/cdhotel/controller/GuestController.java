/**
 * 
 */
package com.cdhotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/guest")
public class GuestController {

	@RequestMapping(value = "/enter")
	public String login() {
		return "欢迎进入，您的身份是游客";
	}

	@RequestMapping(value = "/getMessage")
	public String submitLogin() {
		return "您拥有获得该接口的信息的权限！";
	}
}
