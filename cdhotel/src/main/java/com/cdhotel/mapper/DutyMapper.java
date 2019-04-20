package com.cdhotel.mapper;

import com.cdhotel.model.Duty;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Duty record);

    int insertSelective(Duty record);

    Duty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Duty record);

    int updateByPrimaryKey(Duty record);
}