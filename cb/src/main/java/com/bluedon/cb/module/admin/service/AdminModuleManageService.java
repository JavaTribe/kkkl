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

import com.bluedon.cb.common.entity.Module;
import com.bluedon.cb.common.entity.ParentModule;
import com.bluedon.cb.common.mapper.ModuleMapper;
import com.bluedon.cb.module.admin.mmapper.AdminModuleManageMapper;
import com.bluedon.cb.util.constants.Constants;

import net.sf.ehcache.CacheManager;

/**
 * Description:模块管理
 * Time:2015年12月4日下午12:22:58
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Service
public class AdminModuleManageService {

	@Resource(name="adminModuleManageMapper")
	private AdminModuleManageMapper adminModuleManageMapper;

	@Resource(name="moduleMapper")
	private ModuleMapper moduleMapper;
	
	public List<Map<String, Object>> getModuleList(Map<String, Object> map) {
		return adminModuleManageMapper.selectModuleList(map);
	}

	public int deleteModuleByIds(List<Integer> moduIds) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		for (Integer moduId : moduIds) {
			moduleMapper.deleteByPrimaryKey(moduId);
		}
		return Constants.SUCCESS;
	}


	public int updateModuleByIds(List<Integer> moduIds, Byte moduUseStatus) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		Module module=new Module();
		module.setModuUseStatus(moduUseStatus);
		for (Integer moduId : moduIds) {
			module.setModuId(moduId);
			moduleMapper.updateByPrimaryKeySelective(module);
		}
		return Constants.SUCCESS;
	}

	public int updateModuleByPrimaryKeySelective(Module module) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		return moduleMapper.updateByPrimaryKeySelective(module);
	}

	public int insertModule(Module module) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		return moduleMapper.insertSelective(module);
	}


	public List<ParentModule> getParentModules() {
		// TODO Auto-generated method stub
		return adminModuleManageMapper.selectParentModules();
	}

}
