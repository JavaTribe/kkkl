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

import com.bluedon.cb.common.entity.Department;
import com.bluedon.cb.common.mapper.DepartmentMapper;
import com.bluedon.cb.module.admin.mmapper.AdminDepartmentMapper;

/**
 * Description:部门管理
 * Time:2015年12月4日下午12:23:57
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Service
public class AdminDepartmentService {

	@Resource
	private AdminDepartmentMapper adminDepartmentMapper;
	
	@Resource
	private DepartmentMapper departmentMapper;
	
	/** 部门树Mapper. */
//	@Resource
//	private CommonDepartmentTreeMapper commonDepartmentTreeMapper;
	
	public List<Map<String, Object>> getDepartmentList(
			Map<String, Object> map) {
		return adminDepartmentMapper.selectDepartmentList(map);
	}
	public List<Map<String, Object>> getDepartmentMenu() {
		return adminDepartmentMapper.selectDepartmentMenu(	);
	}
	public int addDepartment(Department department) {
		int result=departmentMapper.insertSelective(department);
		//DepartmentTreeUtil.reloadDepartmentTree(commonDepartmentTreeMapper);
		return result;
	}
	public Department getDepartmentByDepaId(int depaId) {
		return departmentMapper.selectByPrimaryKey(depaId);
	}
	public int updateDepartment(Department department) {
		int result=departmentMapper.updateByPrimaryKeySelective(department);
		//DepartmentTreeUtil.reloadDepartmentTree(commonDepartmentTreeMapper);
		return result;
	}
	public int batchDeleteDepartment(List<Integer> depaIds) {
		int result= adminDepartmentMapper.batchDeleteDepartment(depaIds);
	//	DepartmentTreeUtil.reloadDepartmentTree(commonDepartmentTreeMapper);
		return result;
	}
	public Department getTopDepartment() {
		return adminDepartmentMapper.selectTopDepartment();
	}
	
}
