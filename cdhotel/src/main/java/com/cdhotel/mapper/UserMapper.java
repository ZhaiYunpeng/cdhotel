package com.cdhotel.mapper;

import org.apache.ibatis.annotations.Param;

import com.cdhotel.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	String getUserName(String username);

	void insertUser(@Param("username")String username, @Param("password")String password, @Param("role")String role, @Param("datetime")String datetime);

	User getUser(String username);
}