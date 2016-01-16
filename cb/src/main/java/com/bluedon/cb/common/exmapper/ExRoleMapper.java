/*
 * Copyright (c) 2015 
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.exmapper;

import java.util.List;
import java.util.Map;

import com.bluedon.cb.common.entity.Role;


/**
 * Description:角色扩展Mapper
 * Time:2015年12月4日下午3:03:57
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface ExRoleMapper {

	/**
	 * 通过角色类型取得角色实体
	 * @param map 封装角色类型(byte roleType)
	 * @return 返回角色类型的实体
	 */
	public Role selectRoleByRoleType(Map<String, Object> map);
	
	/**
	 * 通过角色类型列表,查询出对应的角色列表.
	 * @param map 角色类型列表(List<Byte> roleTypes)
	 * @return 角色列表.
	 */
	public List<Role> selectRolesByRoleTypes(Map<String, Object> map);
}
