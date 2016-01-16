/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.Grade;

/**
 * Description:
 * Time:2015年12月2日上午11:38:11
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface GradeMapper {
    int deleteByPrimaryKey(Integer gradId);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gradId);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}