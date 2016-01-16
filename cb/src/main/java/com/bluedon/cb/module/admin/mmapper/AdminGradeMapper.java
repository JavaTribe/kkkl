/*
 * Copyright (c) 2015 
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.mmapper;

import java.util.List;
import java.util.Map;

import com.bluedon.cb.common.entity.Grade;

/**
 * Description:级别Mapper
 * Time:2015年12月4日下午3:14:29
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface AdminGradeMapper {
	
	/**
	 * @param map
	 * @return 对应年份的级别.
	 */
	List<Grade> selectGradeList(Map<String, Object> map);
	
}
