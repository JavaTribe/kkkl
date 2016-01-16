package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.UserBasic;

public interface UserBasicMapper {
    int deleteByPrimaryKey(Integer usbaId);

    int insert(UserBasic record);

    int insertSelective(UserBasic record);

    UserBasic selectByPrimaryKey(Integer usbaId);

    int updateByPrimaryKeySelective(UserBasic record);

    int updateByPrimaryKey(UserBasic record);
}