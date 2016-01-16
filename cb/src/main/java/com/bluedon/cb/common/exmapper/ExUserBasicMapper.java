/*
 * Copyright (c) 2015 
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.exmapper;

import java.util.List;
import java.util.Map;

import com.bluedon.cb.common.entity.UserBasic;




/**
 * Description:用户扩展Mapper
 * Time:2015年12月4日下午3:04:50
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface ExUserBasicMapper {
	
	/**
	 * 通过用户角色ID获得用户信息，包括部门信息
	 * @param usroId 用户角色ID
	 * @return 用户实体
	 */
	public Map<String, Object> selectUserBasicByUsroId(int usroId);
	
	/**
	 * 通过用户ID获得用户信息，包括部门信息
	 * @param usbaId 用户ID
	 * @return 用户实体
	 */
	public Map<String, Object> selectUserBasicByUsbaId(int usbaId);
	
    /**
     * 查询用户实体的基本信息，不全.
     * @param username	：String类型，代表用户用户名
     * @return 返回用户基本信息实体
     */
    UserBasic selectUserBasicByUserAccount(String username);
    
    
    /**
     * 根据用户Id类别,删除对应的用户实体.
     * @param usbaIds 用户Id列表.
     * @return 受影响的行数.
     */
    int batchDeleteUserBasicByUsbaIds(List<Integer> usbaIds);
    
    /**
     * 根据用户名,查询出该用户实体.
     * @param username.
     * @return 用户实体.
     */
    UserBasic selectUserBasicByUsbaAccount(String username);

}
