/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.Department;

/**
 * Description:
 * Time:2015年12月2日上午11:38:07
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer depaId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer depaId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}