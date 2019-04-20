/**
 * 
 */
package com.cdhotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhaiYP
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
//	@Autowired
//	private final ResultMap resultMap;

	@RequestMapping(value = "/getMessage")
	public String getMessage() {
//		try {
//			throw new Exception("Error测试！！！");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return  "您拥有管理员权限，可以获得该接口的信息！";
	}
}
