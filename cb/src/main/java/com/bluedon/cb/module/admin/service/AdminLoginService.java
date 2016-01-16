/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bluedon.cb.common.entity.AdminRole;
import com.bluedon.cb.common.exmapper.ExAdminRoleMapper;


/**
 * Description:管理员登录
 * Time:2015年12月4日下午12:23:11
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Service
public class AdminLoginService{

	@Resource
	private ExAdminRoleMapper exAdminRoleMapper;
	
	/**
	  * @Description: 通过管理员ID获取管理员角色ID
	  * @param map
	  * @return
	  */
	public List<AdminRole> getAdminRoleByAdmiId(Map<String, Object> map) {
		return exAdminRoleMapper.selectAdminRoleByAdmiId(map);
	}

}
