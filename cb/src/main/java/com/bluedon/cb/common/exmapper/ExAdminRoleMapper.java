/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.common.exmapper;

import java.util.List;
import java.util.Map;

import com.bluedon.cb.common.entity.AdminRole;

/**
 * Description:管理员角色扩展Mapper
 * Time:2015年12月4日下午3:02:48
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface ExAdminRoleMapper {
	
    /**
     * 通过管理员ID得到管理员角色列表.
     * @param map 封装管理员ID(int admiId)
     * @return 管理员角色实体
     */
    public List<AdminRole> selectAdminRoleByAdmiId(Map<String, Object> map);
    
    /**
     * 通过管理员角色ID列表得到管理员角色列表.
     * @param adroIds 封装管理员角色ID列表
     * @return 管理员角色实体列表
     */
    public List<AdminRole> selectAdminRoleListByAdroIds(List<Integer> adroIds);
    
    /**
     * 通过管理员角色Id得到管理员角色实体（包括管理员实体，角色实体）
     * @param adroId 管理员角色的Id
     * @return 返回管理员角色实体（包括管理员实体，角色实体）
     */
    public AdminRole selectAdminRoleByAdroId(int adroId);
    
}
