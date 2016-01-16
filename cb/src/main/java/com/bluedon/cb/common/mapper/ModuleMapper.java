/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.mapper;

import com.bluedon.cb.common.entity.Module;

/**
 * Description:
 * Time:2015年12月2日上午11:38:16
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public interface ModuleMapper {
    int deleteByPrimaryKey(Integer moduId);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer moduId);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}