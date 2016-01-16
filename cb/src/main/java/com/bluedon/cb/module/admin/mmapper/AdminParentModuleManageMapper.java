/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.mmapper;

import java.util.List;
import java.util.Map;

/**
 * Description:父模块管理Mapper
 * Time:2015年12月4日下午3:15:05
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface AdminParentModuleManageMapper {
	
	/**
	 * @param map
	 * @return 对应年份父模块列表
	 */
	List<Map<String, Object>> selectParentModuleList(Map<String, Object> map);
}
