/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluedon.cb.common.entity.ParentModule;
import com.bluedon.cb.common.service.RoleModuleService;
import com.bluedon.cb.util.constants.Constants;
import com.bluedon.cb.util.paging.PageContext;
/**
 * Description		: 
 * 管理员页面初始化.
 * 
 * <br><br>Time		: 2015-11-2003  下午3:20:53
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author chenchengteng
 */
@Controller
@RequestMapping("/admin/init")
public class AdminInitController {
	
	
	@Resource
	private RoleModuleService roleModuleService;
	@Resource(name="applicationPropertiesFactoryBean")
	private Properties properties;
	
	/** log. */
	private Logger log = LoggerFactory.getLogger(AdminInitController.class);
	/**
	 * 初始化管理员主页,包括动态初始化侧边栏,顶部信息栏.
	 * @param model model模型.
	 * @return 跳转的页面.
	 */
	@RequestMapping("/initPage")
	public String initPage(HttpServletRequest request , Model model) {
		System.out.println(properties.getProperty("mysql.driverClassName"));
		List<ParentModule> parentModules = new ArrayList<ParentModule>();
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constants.ROLE_ID, (Integer) session.getAttribute(Constants.ROLE_ID));
		map.put("admeLookStatus", 0);
		map.put(Constants.ADMIN_ROLE_ID, (Integer) session.getAttribute(Constants.ADMIN_ROLE_ID));
		PageContext.getContext().setPagination(false);
		parentModules = roleModuleService.getParentModuleByRoleId(map);
		model.addAttribute("parentModules", parentModules);
		return "/admin/init/init_page";
	}
}
