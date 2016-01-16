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
 * Description:角色权限配置Mapper
 * Time:2015年12月4日下午3:15:24
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface AdminRoleManageMapper {

	/**
	  * @Description: 获取所有角色List
	  * @param map
	  * @return
	  */
	List<Map<String, Object>> selectRoleList(Map<String, Object> map);
	
	/**
	  * @Description: 所有启用的模块
	  * @param map
	  * @return
	  */
	List<ParentModule> selectParentModuleAndModule(Map<String, Object> map);
	
	/**
	 * 解除角色ID与模块之间的关系
	 * @param roleId
	 * @return 
	 */
	int deleteRoleModuleByRoleId(Integer roleId);
	
	/**
	 * 插入新的角色Id与模块关系
	 * @param map
	 */
	void insertRoleModules(Map<String, Object> map);
	
	/**
	 * @param roleId
	 * @return 当前角色Id绑定的ModuId
	 */
	List<Integer> selectModuIdsByRoleId(int roleId);
	
}
