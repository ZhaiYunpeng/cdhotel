/**
 * 
 */
package com.cdhotel.service;

import com.cdhotel.model.User;

/**
 * @author 
 *	
 */
public interface UserService {
	
	/**
	 * TODO　判断用户名是否存在
	 * @param username
	 * @return
	 * boolean
	 * @CREATE_TIME:2019年4月20日
	 */
	public boolean nameIsExist(String username);
	
	/**
	 * TODO	判断用户是否存在
	 * @param username
	 * @param password
	 * @return
	 * boolean
	 * @CREATE_TIME:2019年4月20日
	 */
	public boolean userIsExist(String username,String password);
	
	/**
	 * TODO	简单注册用户
	 * @param username
	 * @param password
	 * @return
	 * boolean
	 * @CREATE_TIME:2019年4月20日
	 */
	public boolean register(User user);
	
	/**
	 * TODO	修改信息
	 * @param user
	 * @return
	 * boolean
	 * @CREATE_TIME:2019年4月20日
	 */
	public boolean updateUser(User user);
}
