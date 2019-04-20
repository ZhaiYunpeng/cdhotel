package com.cdhotel.mapper;

import com.cdhotel.model.RoomList;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomList record);

    int insertSelective(RoomList record);

    RoomList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomList record);

    int updateByPrimaryKey(RoomList record);
}