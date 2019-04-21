package com.cdhotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Administrator
 * @Date: 2019/4/21 00:53
 * @Description:
 */
@Configuration
public class IndexView implements WebMvcConfigurer {

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "index" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        WebMvcConfigurer.super.addViewControllers( registry );
    }
}
