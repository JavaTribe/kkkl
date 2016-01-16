/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.mmapper;

import java.util.List;
import java.util.Map;

import com.bluedon.cb.common.entity.ParentModule;


/**
 * Description:模块管理Mapper
 * Time:2015年12月4日下午3:14:39
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface AdminModuleManageMapper {
	
	/**
	 * @param map
	 * @return 对应年份模块列表
	 */
	List<Map<String, Object>> selectModuleList(Map<String, Object> map);
	
	List<ParentModule> selectParentModules();
	
}
