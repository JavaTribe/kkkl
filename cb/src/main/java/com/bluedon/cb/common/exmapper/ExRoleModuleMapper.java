/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.common.exmapper;

import java.util.List;
import java.util.Map;

import com.bluedon.cb.common.entity.RoleModule;


/**
 * Description:角色模块扩展Mapper
 * Time:2015年12月4日下午3:04:31
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface ExRoleModuleMapper {

    /**
     * 通过角色ID得到角色模块列表.
     * @param map 封装角色ID(int roleId)
     * @return 角色模块实体
     */
    public List<RoleModule> selectRoleModuleByRoleId(Map<String, Object> map);
    
}
