/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.common.exmapper;

import java.util.List;
import java.util.Map;

import com.bluedon.cb.common.entity.ParentModule;


/**
 * Description:父模块扩展Mapper
 * Time:2015年12月4日下午3:03:05
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface ExParentModuleMapper {

    
    /**
     * 通过角色Id查询所有的权限模块.
     * @param map 角色Id(int roleId)
     * @return 权限模块实体.
     */
    List<ParentModule> selectParentModuleByRoleId(Map<String, Object> map);
}
