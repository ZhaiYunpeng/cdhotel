package com.cdhotel.mapper;

import com.cdhotel.model.Signin;
import org.springframework.stereotype.Repository;

@Repository
public interface SigninMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Signin record);

    int insertSelective(Signin record);

    Signin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Signin record);

    int updateByPrimaryKey(Signin record);
}