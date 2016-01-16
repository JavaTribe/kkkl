/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.UserRole;

/**
 * Description:
 * Time:2015年12月2日上午11:38:36
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer usroId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer usroId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}