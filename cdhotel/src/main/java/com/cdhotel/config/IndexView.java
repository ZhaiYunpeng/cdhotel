/**
 * 
 */
package com.cdhotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 
 *
 */
@SuppressWarnings("deprecation")
@Configuration
public class IndexView extends WebMvcConfigurerAdapter{
	 @Override 
	 public void addViewControllers( ViewControllerRegistry registry ) { 
//		 registry.addViewController( "/" ).setViewName( "forward:/WEB-INF/jsp/login.jsp" ); 
		 registry.addViewController( "/" ).setViewName( "forward:/WEB-INF/jsp/index.jsp" ); 
		 registry.setOrder( Ordered.HIGHEST_PRECEDENCE ); 
		 super.addViewControllers( registry ); } 
}
