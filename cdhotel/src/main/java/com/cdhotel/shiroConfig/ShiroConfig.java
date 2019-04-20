package com.cdhotel.shiroConfig;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author ZhaiYP
 */
@Configuration
public class ShiroConfig {

	private static Logger log = Logger.getLogger(ShiroConfig.class.getName());
	
    /**
     * TODO 自定义身份认证 realm;
     *
     * @return CustomRealm
     * @CREATE_TIME:2018年12月27日
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

    /**
     * TODO 注入 securityManager
     *
     * @return SecurityManager
     * @CREATE_TIME:2018年12月27日
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }


    /**
     * TODO 配置拦截器工厂
     *
     * @param securityManager securityManager
     * @return ShiroFilterFactoryBean
     * @CREATE_TIME: 2018年12月27日
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/notLogin");
        // 设置无权限时跳转的 url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

        // 设置拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //游客，开发权限
        filterChainDefinitionMap.put("/guest/**", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/index", "anon");
      //用户，需要角色权限 “roomer”
        filterChainDefinitionMap.put("/roomer/**", "roles[roomer]");
        //用户，需要角色权限 “employee”
        filterChainDefinitionMap.put("/employee/**", "roles[employee]");
        //管理员，需要角色权限 “admin”
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        //开放登陆接口
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/", "anon");
        //其余接口一律拦截
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        filterChainDefinitionMap.put("/**", "authc");

//        shiroFilterFactoryBean.setLoginUrl("/login");
//        System.out.println("ShiroConfiguration.shirFilter() success");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/websocket");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        log.info("Shiro拦截器工厂类注入成功！");
        return shiroFilterFactoryBean;
    }

//    @Bean
//    public SessionManager sessionManager() {
//        DefaultSessionManager sessionManager = new DefaultSessionManager();
//        //  定义的是全局的session会话超时时间
//        sessionManager.setGlobalSessionTimeout(30*60*1000);
//        sessionManager.setSessionValidationInterval(3000);
//        sessionManager.setSessionValidationSchedulerEnabled(true);
//        return sessionManager;
//    }

}
