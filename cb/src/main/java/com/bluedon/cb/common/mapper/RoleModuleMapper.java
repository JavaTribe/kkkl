/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.RoleModule;

/**
 * Description:
 * Time:2015年12月2日上午11:38:28
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface RoleModuleMapper {
    int deleteByPrimaryKey(Integer romoId);

    int insert(RoleModule record);

    int insertSelective(RoleModule record);

    RoleModule selectByPrimaryKey(Integer romoId);

    int updateByPrimaryKeySelective(RoleModule record);

    int updateByPrimaryKey(RoleModule record);
}