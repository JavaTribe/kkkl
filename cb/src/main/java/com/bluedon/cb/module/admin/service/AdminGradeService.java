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

import com.bluedon.cb.common.entity.Grade;
import com.bluedon.cb.module.admin.mmapper.AdminGradeMapper;

/**
 * Description:级别管理
 * Time:2015年12月4日下午12:23:36
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Service
public class AdminGradeService {
	
	@Resource
	private AdminGradeMapper adminGradeMapper;

	/**
	  * @Description: 获取级别列表
	  * @param map
	  * @return
	  */
	public List<Grade> getGradeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return adminGradeMapper.selectGradeList(map);
	}
	

}
