/*
	 * Copyright (c) 2015 
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluedon.cb.common.entity.AdminRole;
import com.bluedon.cb.common.entity.Administrator;
import com.bluedon.cb.module.admin.service.AdminLoginService;
import com.bluedon.cb.util.constants.Constants;

/**
 * Description		: 
 * 
 * <br><br>Time		: 2015-11-203  下午10:00:17
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author ICE
 */
@Controller
@RequestMapping("/admin/login")
public class AdminLoginController {
	
	@Resource
	private AdminLoginService adminLoginService;
	
	@RequestMapping("/adminCheckSuccess")
	@ResponseBody
	public Map<String, Object> adminCheckSuccess(HttpServletRequest req,HttpServletResponse resp) {
		Administrator administrator = (Administrator)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("admiId", administrator.getAdmiId());
		List<AdminRole> adminRoles = adminLoginService.getAdminRoleByAdmiId(map);
		Map<String, Object> msg = new HashMap<String, Object>();
		if(adminRoles.size() > 1) {
			msg.put("message", "chooseRole");
			msg.put("address", "admin/login/chooseRole");
		}
		else if(adminRoles.size() ==1 ) {
			AdminRole adminRole = adminRoles.get(0);
			//参数为：管理员角色ID，角色ID
			String param = adminRole.getAdroId()+","+adminRole.getAdroRole().getRoleId()+","+adminRole.getAdroRole().getRoleName()+","+adminRole.getAdroAdminstrator().getAdmiAccount();
			msg.put("message", "success");
			msg.put("address", "admin/login/initData?adIds="+param);
		}
		return msg;
	}
	
	@RequestMapping("/chooseRole")
	public String getStudentRole(Model model){
		Administrator administrator = (Administrator)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("admiId", administrator.getAdmiId());
		List<AdminRole> adminRoles = adminLoginService.getAdminRoleByAdmiId(map);
		model.addAttribute("adminRoles", adminRoles);
		return "admin/login/choose_role";
	}
	
	@RequestMapping("/initData")
	public String initData(HttpServletRequest req, String adIds) {
		HttpSession session = req.getSession();
		//角色
		session.removeAttribute(Constants.ROLE_ID);
		session.removeAttribute(Constants.ADMIN_ROLE_ID);
		String[] ids = adIds.split(",");
		session.setAttribute(Constants.ADMIN_ROLE_ID, Integer.parseInt(ids[0]));
		session.setAttribute(Constants.ROLE_ID, Integer.parseInt(ids[1]));
		session.setAttribute(Constants.ROLE_NAME, ids[2]);
		session.setAttribute(Constants.ADMI_ACCOUNT, ids[3]);
		session.setAttribute(Constants.SESSION_ID, req.getSession().getId());
		return "redirect:/admin/init/initPage";
	}
}
