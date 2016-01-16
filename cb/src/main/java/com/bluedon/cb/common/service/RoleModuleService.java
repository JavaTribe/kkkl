/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bluedon.cb.common.entity.ParentModule;
import com.bluedon.cb.common.entity.RoleModule;
import com.bluedon.cb.common.exmapper.ExParentModuleMapper;
import com.bluedon.cb.common.exmapper.ExRoleModuleMapper;

/**
 * Description		: 
 * 
 * 
 * <br><br>Time		: 2015-11-200  上午9:15:56
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author chenchengteng
 */
@Service
public class RoleModuleService {

	@Resource
	private ExRoleModuleMapper exRoleModuleMapper;
	
	@Resource
	private ExParentModuleMapper exParentModuleMapper;
	
	@Cacheable(value="roleModelCache",key="#map.get(\"roleId\")")
	public List<RoleModule> getRoleModuleByRoleId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return exRoleModuleMapper.selectRoleModuleByRoleId(map);
	}
	
	@Cacheable(value="parentModuleCache",key="#map.get(\"roleId\")")
	public List<ParentModule> getParentModuleByRoleId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return exParentModuleMapper.selectParentModuleByRoleId(map);
	}
	

}
