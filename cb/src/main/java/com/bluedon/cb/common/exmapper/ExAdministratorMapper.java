/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.common.exmapper;

import com.bluedon.cb.common.entity.Administrator;



/**
 * Description:管理员扩展Mapper
 * Time:2015年12月4日下午3:02:21
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface ExAdministratorMapper {

    /**
     * 通过ID查询管理员实体.
     * @param username	:String类型，代表管理员用户名
     * @return 返回管理员基本信息实体
     */
    Administrator selectAdministratorByUsername(String username);
    
}
