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

import com.bluedon.cb.common.entity.ParentModule;
import com.bluedon.cb.common.mapper.ParentModuleMapper;
import com.bluedon.cb.module.admin.mmapper.AdminParentModuleManageMapper;
import com.bluedon.cb.util.constants.Constants;

import net.sf.ehcache.CacheManager;

/**
 * Description:父模块管理
 * Time:2015年12月4日下午12:22:41
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Service
public class AdminParentModuleManageService {

	@Resource
	private AdminParentModuleManageMapper adminParentModuleManageMapper;
	
	@Resource
	private ParentModuleMapper parentModuleMapper;
	
	public List<Map<String, Object>> getParentModuleList(Map<String, Object> map) {
		
		return adminParentModuleManageMapper.selectParentModuleList(map);
	}

	public int deleteParentModuleByIds(List<Integer> pamoIds) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		
		for (Integer pamoId : pamoIds) {
			parentModuleMapper.deleteByPrimaryKey(pamoId);
		}
		return Constants.SUCCESS;
	}

	public int updateParentModuleByIds(List<Integer> pamoIds, Byte pamoUseStatus) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		
		ParentModule parentModule=new ParentModule();
		parentModule.setPamoUseStatus(pamoUseStatus);
		for (Integer pamoId : pamoIds) {
			parentModule.setPamoId(pamoId);
			parentModuleMapper.updateByPrimaryKeySelective(parentModule);
		}
		return Constants.SUCCESS;
		
	}

	public int updateParentModuleByPrimaryKeySelective(ParentModule parentModule) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		return parentModuleMapper.updateByPrimaryKeySelective(parentModule);
	}

	public int insertParentModule(ParentModule parentModule) {
	    CacheManager manager = CacheManager.create();     //通过manager可以生成指定名称的Cache对象
	    manager.getCache("roleModelCache").removeAll();
	    manager.getCache("parentModuleCache").removeAll();
		return parentModuleMapper.insertSelective(parentModule);
	}

}
