/**
 *
 */
package com.cdhotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdhotel.model.User;
import com.cdhotel.service.UserService;

/**
 * @author ZhaiYP
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getMessage")
    public String getMessage() {
        return "您拥有用户权限，可以获得该接口的信息！";
    }

    @RequestMapping("Test")
    public User userTest() {
        User user = new User();
        user.setName("UserTest");
        return user;
    }

//    @RequestMapping("getUser")
//    public User getUser() {
//        int i = 0;
//        User user = null;
//        while (i < 10000) {
//            user = userService.getUserByID(1);
//            i++;
//        }
//        return user;
//    }
}
