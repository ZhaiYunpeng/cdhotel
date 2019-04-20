package com.cdhotel.shiroConfig;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdhotel.mapper.UserMapper;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhaiYP
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 授权，验证当前用户是否有权限进行该项操作
     * 获取身份验证信息 Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String role = userMapper.getRolenameByUserame(username);
        Set<String> set = new HashSet<>();
        set.add(role);
        info.setRoles(set);
        return info;
    }

    /**
     * 登录身份验证
     * 获取授权信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
//        System.out.println("---------登录验证方法-------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        String password = new String(token.getPassword());
        int userIsExist = userMapper.userIsExist(userName,password);
        if (userIsExist == 0) {
            throw new AccountException("用户名或密码不正确");
//            return  null;
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
    }

}
