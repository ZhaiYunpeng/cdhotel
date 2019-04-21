/**
 *
 */
package com.cdhotel.controller.common;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Controller
public class ExceptionController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer)
                request.getAttribute("javax.servlet.error.status_code");
//        log.error("当前访问状态码为："+statusCode);
        
//        if (statusCode == 401) {
//            return "/401";
//        } else if (statusCode == 404) {
////            return "/404";
//            return getErrorPath();
//        } else if (statusCode == 403) {
//            return "/403";
//        } else {
//            return "/500";
//        }
        return "/common/error";
    }

    @Override
    public String getErrorPath() {
        return "/common/error";
    }
}
