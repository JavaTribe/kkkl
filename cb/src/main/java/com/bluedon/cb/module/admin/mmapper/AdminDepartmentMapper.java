/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.mmapper;

import java.util.List;
import java.util.Map;

import com.bluedon.cb.common.entity.Department;


/**
 * Description:部门Mapper
 * Time:2015年12月4日下午3:14:13
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface AdminDepartmentMapper {
	
	/**
	 * @param map
	 * @return 对应年份的和满足查询条件的部门.
	 */
	List<Map<String, Object>> selectDepartmentList(Map<String, Object> map);
	
	/**
	 * @return  该年份的、除了最低级的所有部门.
	 */
	List<Map<String, Object>> selectDepartmentMenu();
	
	/**
	 * @param depaIds
	 * @return 删除成功影响行数.
	 */
	int batchDeleteDepartment(List<Integer> depaIds);
	
	/**
	 * @return 顶级部门.
	 */
	Department selectTopDepartment();
	
	/**
	 * 批量插入部门.
	 * @param map
	 * @return
	 */
	int batchInsertDepartment(Map<String, Object> map);
}
