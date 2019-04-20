package com.cdhotel.mapper;

import com.cdhotel.model.Performance;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Performance record);

    int insertSelective(Performance record);

    Performance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Performance record);

    int updateByPrimaryKey(Performance record);
}