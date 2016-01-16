/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.ParentModule;

/**
 * Description:
 * Time:2015年12月2日上午11:38:20
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface ParentModuleMapper {
    int deleteByPrimaryKey(Integer pamoId);

    int insert(ParentModule record);

    int insertSelective(ParentModule record);

    ParentModule selectByPrimaryKey(Integer pamoId);

    int updateByPrimaryKeySelective(ParentModule record);

    int updateByPrimaryKey(ParentModule record);
}