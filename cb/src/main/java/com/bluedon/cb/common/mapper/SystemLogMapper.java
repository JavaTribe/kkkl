package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.SystemLog;

public interface SystemLogMapper {
    int deleteByPrimaryKey(Integer syloId);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    SystemLog selectByPrimaryKey(Integer syloId);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}