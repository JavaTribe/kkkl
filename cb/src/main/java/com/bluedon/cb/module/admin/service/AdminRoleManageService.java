/*
 * Copyright (c) 2015 
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bluedon.cb.common.entity.ParentModule;
import com.bluedon.cb.common.entity.Role;
import com.bluedon.cb.common.mapper.RoleMapper;
import com.bluedon.cb.module.admin.mmapper.AdminRoleManageMapper;
import com.bluedon.cb.util.constants.Constants;

import net.sf.ehcache.CacheManager;


/**
 * Description:角色管理
 * Time:2015年12月4日下午12:20:56
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Service
public class AdminRoleManageService {

	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private AdminRoleManageMapper adminRoleManageMapper;
	
	public List<Map<String, Object>> getRoleList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return adminRoleManageMapper.selectRoleList(map);
	}

	public int deleteRoleIds(List<Integer> roleIds) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		for (Integer roleId : roleIds) {
			roleMapper.deleteByPrimaryKey(roleId);
		}
		return Constants.SUCCESS;
	}

	public List<ParentModule> getParentModuleAndModule() {
		Map<String, Object> map=new HashMap<String, Object>();
		return adminRoleManageMapper.selectParentModuleAndModule(map);
	}

	public int updateRoleAndRoleModule(Role role, List<Integer> moduIds) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		roleMapper.updateByPrimaryKeySelective(role);
		adminRoleManageMapper.deleteRoleModuleByRoleId(role.getRoleId());
		if(moduIds.size() > 0){
			Map< String, Object> map=new HashMap<String, Object>();
			map.put("roleId", role.getRoleId());
			map.put("romoCreateDate", new Date());
			map.put("moduIds", moduIds);
			adminRoleManageMapper.insertRoleModules(map);
		}
		return Constants.SUCCESS;
	}

	public int insertRoleAndRoleModule(Role role, List<Integer> moduIds) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		role.setRoleCreateDate(new Date());
		roleMapper.insertSelective(role);
		if(moduIds.size() > 0){
			Map< String, Object> map=new HashMap<String, Object>();
			map.put("roleId", role.getRoleId());
			map.put("romoCreateDate", new Date());
			map.put("moduIds", moduIds);
			adminRoleManageMapper.insertRoleModules(map);
		}
		return Constants.SUCCESS;
	}


}
