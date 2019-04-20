package com.cdhotel.mapper;

import com.cdhotel.model.User;

/**
 * @author 
 *
 */
public interface UserMapper {
	
	/**
	 * TODO	根据用户名,密码判断用户是否存在
	 * @param username
	 * @param password
	 * @return
	 * int
	 * @CREATE_TIME:2019年4月20日
	 */
	int userIsExist(String username,String password);
	
	/**
	 * TODO	查询改名称用户有几个
	 * @param username
	 * @return
	 * int
	 * @CREATE_TIME:2019年4月20日
	 */
	int getNumByUsername(String username);
	
    /**
     * TODO	根据Id删除用户
     * @param id
     * @return
     * int
     * @CREATE_TIME:2019年4月20日
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * TODO	保存信息
     * @param record
     * @return
     * int
     * @CREATE_TIME:2019年4月20日
     */
    int insert(User record);

    /**
     * TODO
     * @param record
     * @return
     * int
     * @CREATE_TIME:2019年4月20日
     */
    int insertSelective(User record);

    /**
     * TODO	根据ID选择用户
     * @param id
     * @return
     * User
     * @CREATE_TIME:2019年4月20日
     */
    User selectByPrimaryKey(Integer id);

    /**
     * TODO	部分修改用户
     * @param record
     * @return
     * int
     * @CREATE_TIME:2019年4月20日
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * TODO	根据ID 修改用户信息
     * @param record
     * @return
     * int
     * @CREATE_TIME:2019年4月20日
     */
    int updateByPrimaryKey(User record);
}