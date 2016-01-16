/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.Administrator;

/**
 * Description:
 * Time:2015年12月2日上午11:37:30
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer admiId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer admiId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
}