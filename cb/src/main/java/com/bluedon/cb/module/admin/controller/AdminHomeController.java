/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description		: 
 * 
 * 
 * <br><br>Time		: 2015-11-202  上午2:19:28
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author chenchengteng
 */
@Controller
@RequestMapping("/admin/home")
public class AdminHomeController {
	
	/**
	 * @return 管理员首页.
	 */
	@RequestMapping("/page")
	public String page(Model model,  HttpServletRequest request) {
//		model.addAttribute("week", DateUtils.getWeek());
//        model.addAttribute("date", DateUtils.getDate("yyyy年MM月dd日"));

        model.addAttribute("javaVersion", System.getProperty("java.version")); // 获取JAVA版本
        model.addAttribute("osName", System.getProperty("os.name")); // 获取系统名称
        model.addAttribute("osArch", System.getProperty("os.arch")); // 获取系统构架
        model.addAttribute("osVersion", System.getProperty("os.version")); // 获取系统版本
        model.addAttribute("serverInfo", StringUtils.substring(
                request.getServletContext().getServerInfo(), 0, 30)); // 获取Server信息
        model.addAttribute("loginIP", request.getRemoteAddr()); // 获取登录IP地址
        model.addAttribute("servletVersion", request.getServletContext().getMajorVersion() + "."
                + request.getServletContext().getMinorVersion()); // 获取Servlet版本
		return "/admin/home/page";
	}
}
