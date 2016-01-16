/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.AdminRole;

/**
 * Description:
 * Time:2015年12月2日上午11:38:02
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface AdminRoleMapper {
    int deleteByPrimaryKey(Integer adroId);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Integer adroId);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}