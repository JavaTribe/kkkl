/*
 * Copyright (c) 2015 
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bluedon.cb.common.entity.Role;
import com.bluedon.cb.common.entity.UserBasic;
import com.bluedon.cb.common.entity.UserRole;
import com.bluedon.cb.common.exmapper.ExRoleMapper;
import com.bluedon.cb.common.exmapper.ExUserBasicMapper;
import com.bluedon.cb.common.exmapper.ExUserRoleMapper;
import com.bluedon.cb.common.mapper.UserBasicMapper;
import com.bluedon.cb.common.mapper.UserRoleMapper;
import com.bluedon.cb.module.admin.mmapper.AdminManageUserAccountMapper;
import com.bluedon.cb.util.EncryptMD5Util;
import com.bluedon.cb.util.constants.Constants;

/**
 * Description		: 
 * 
 * 
 * <br><br>Time		: 2015-11-20  下午11:20:40
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author CCT
 */
@Service
public class AdminManageUserAccountService{

	@Resource
	private AdminManageUserAccountMapper adminManageUserAccountMapper;
	
	@Resource
	private UserBasicMapper UserBasicMapper;
	
	@Resource
	private ExUserBasicMapper exUserBasicMapper;
	
	@Resource
	private ExRoleMapper exRoleMapper;
	
	@Resource
	private UserRoleMapper UserRoleMapper;
	
	@Resource
	private ExUserRoleMapper exUserRoleMapper;
	
	public List<Map<String, Object>> getUserAccountList(
			Map<String, Object> map) {
		return adminManageUserAccountMapper.selectUserAccountList(map);
	}
	
	public Map<String, Object> getUserDetailsByUsbaId(int tebaId) {
		Map<String, Object> map = adminManageUserAccountMapper.selectUserDetailsByUsbaId(tebaId);
		return map;
	}
	
	public int updateUserAccountPasswordByUsbaId(int tebaId, String resetPassword) {
		UserBasic UserBasic = new UserBasic();
		UserBasic.setUsbaId(tebaId);
		UserBasic.setUsbaPassword(EncryptMD5Util.eccrypt(resetPassword));
		int success = UserBasicMapper.updateByPrimaryKeySelective(UserBasic);
		
		return success;
	}

	public int updateUserAccountByUsbaId(int tebaId, String tebaNo, String tebaName, 
			byte tebaAccountEnable, byte tebaAccountLocked, int depaId, String tebaAttribute4) {
		UserBasic UserBasic = new UserBasic();
		UserBasic.setUsbaId(tebaId);
		UserBasic.setUsbaAccount(tebaNo);
		UserBasic.setUsbaName(tebaName);
		UserBasic.setUsbaAccountEnable(tebaAccountEnable);
		UserBasic.setUsbaAccountLocked(tebaAccountLocked);
		UserBasic.setDepaId(depaId);
		int success = UserBasicMapper.updateByPrimaryKeySelective(UserBasic);
		return success;
	}

	public int addUserBasic(UserBasic UserBasic) {
		UserBasic.setUsbaPassword(EncryptMD5Util.eccrypt(Constants.RESET_PASSWORD));
		int success = UserBasicMapper.insertSelective(UserBasic);
		return success;
	}

	public UserBasic getUserBasicByUserName(String username) {
		UserBasic UserBasic = exUserBasicMapper.selectUserBasicByUsbaAccount(username);
		return UserBasic;
	}

	public int updateUserBasicEnableByUsbaIds(List<Integer> tebaIds,
			byte accountEnable) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tebaIds", tebaIds);
		map.put("tebaAccountEnable", accountEnable);
		int num = adminManageUserAccountMapper.updateUserBasicEnableByUsbaIds(map);
		return num;
	}

	public int removeUserBasicByUsbaId(List<Integer> tebaIds) {
		int num = exUserBasicMapper.batchDeleteUserBasicByUsbaIds(tebaIds);
		return num;
	}

	public List<Map<String, Object>> getUserRoleByUsbaId(int tebaId) {
		List<Map<String, Object>> list = adminManageUserAccountMapper.selectUserRoleByUsbaId(tebaId);
		return list;
	}

	public List<Role> getRoleByRoleTypes(List<Byte> roleTypes) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleTypes", roleTypes);
		List<Role> roles = exRoleMapper.selectRolesByRoleTypes(map);
		return roles;
	}

	public int addUserRole(UserRole UserRole) {
		int num = UserRoleMapper.insertSelective(UserRole);
		return num;
	}

	public int updateUserRoleStatusByUsroIds(List<Integer> teroIds, byte status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teroIds", teroIds);
		map.put("status", status);
		int num = adminManageUserAccountMapper.updateUserRoleStatusByUsroIds(map);
		return num;
	}

	public int removeUserRoleByUsroIds(List<Integer> teroIds) {
		int num = exUserRoleMapper.batchDeleteUserRole(teroIds);
		return num;
	}

	public int batchUpdateUserAccountEnable(List<Integer> usbaIds,
			byte enableStatus) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usbaIds", usbaIds);
		map.put("enableStatus", enableStatus);
		int success = adminManageUserAccountMapper.batchUpdateUserAccountEnableByUsbaIds(map);
		return success;
	}
}
