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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bluedon.cb.common.entity.ParentModule;
import com.bluedon.cb.common.entity.Role;
import com.bluedon.cb.common.mapper.RoleMapper;
import com.bluedon.cb.module.admin.mmapper.AdminRoleManageMapper;
import com.bluedon.cb.module.admin.service.AdminRoleManageService;
import com.bluedon.cb.util.PageUtil;
import com.bluedon.cb.util.constants.Constants;
import com.bluedon.cb.util.constants.DTConstants;
import com.bluedon.cb.util.paging.PageContext;

/**
 * Description		: 
 * 
 * 
 * <br><br>Time		: 2015-11-200  下午3:03:07
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author CCT
 */
@Controller
@RequestMapping("/admin/roleManage")
public class AdminRoleManageController {
	
	@Resource
	private AdminRoleManageService adminRoleManageService;
	
	@Resource
	private AdminRoleManageMapper adminRoleManageMapper;
	
	@Resource(name="roleMapper")
	private RoleMapper roleMapper;
	
	@RequestMapping("toRoleManageList")
	public String toRoleManageList() {
		return "admin/rolemanage/role_manage_list";
	}
	
	@RequestMapping("toRoleManageAddOREdit")
	public String toRoleManageAddOREdit(Model model,HttpServletRequest request){
		//编辑角色ID
		String editRoleId=request.getParameter("editRoleId");
		PageContext.getContext().setPagination(false);
		List<ParentModule> parentModules= adminRoleManageService.getParentModuleAndModule();
		if(StringUtils.isNotBlank(editRoleId)){//获取编辑信息
			Role role=roleMapper.selectByPrimaryKey(Integer.parseInt(editRoleId));
			List<Integer> moduIds=adminRoleManageMapper.selectModuIdsByRoleId(Integer.parseInt(editRoleId));
			model.addAttribute("moduIds", JSON.toJSONString(moduIds));
			model.addAttribute("editRoleId", editRoleId);
			model.addAttribute("role", role);
		}
		model.addAttribute("parentModules", parentModules);
		return "admin/rolemanage/role_manage_add_edit";
	}
	
	/**
	 * 保存新建或编辑角色权限
	 * @param request
	 * @return
	 */
	@RequestMapping("saveRoleMange")
	public String saveRoleMange(HttpServletRequest request){
		String roleId=request.getParameter("roleId");
		String roleName=request.getParameter("roleName");
		String roleUseStatus=request.getParameter("roleUseStatus");
		String roleType=request.getParameter("roleType");
		String roleDescribe=request.getParameter("roleDescribe");
		String[] moduleIds=request.getParameterValues("moduleId");
		Role role=new Role();
		List<Integer> moduIds=new ArrayList<Integer>();
		int result;
		//是否有配置模块
		if (moduleIds != null) {
			for (String moduleId : moduleIds) {
				moduIds.add(Integer.parseInt(moduleId));
			}
		}
		if(StringUtils.isNotBlank(roleName)) {
			role.setRoleName(roleName);
		}
		if(StringUtils.isNotBlank(roleDescribe)) {
			role.setRoleDescribe(roleDescribe);
		}
		if(StringUtils.isNotBlank(roleUseStatus)) {
			role.setRoleUseStatus(Byte.parseByte(roleUseStatus));
		}
		if(StringUtils.isNotBlank(roleType)) {
			role.setRoleType(Byte.parseByte(roleType));
		}
		//更新
		if(StringUtils.isNotBlank(roleId)) {
			role.setRoleId(Integer.parseInt(roleId));
			result=adminRoleManageService.updateRoleAndRoleModule(role, moduIds);
		}else {//插入
			result=adminRoleManageService.insertRoleAndRoleModule(role, moduIds);
		}
		return "admin/rolemanage/role_manage_list";
	}
	
	/**
	 * @param request
	 * @param sEcho
	 * @param iDisplayStart
	 * @param iDisplayLength
	 * @param iTotalRows
	 * @param sAction
	 * @param sGroupActionName
	 * @return 角色列表.
	 */
	@RequestMapping("/getRoleManageList")
	@ResponseBody
	public Map<String, Object> getRoleManageList(HttpServletRequest request, String sEcho, String iDisplayStart, String iDisplayLength, String iTotalRows, String sAction,String sGroupActionName ) {
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> map=new HashMap<String, Object>();
		if(StringUtils.isNotEmpty(sAction)){
			//提交
			if(DTConstants.GROUP_ACTION.equals(sAction)){
				// 获取选中的记录id
				String idArray = request.getParameter("idArarry");
				if (idArray != null) {
					// 分割为id数组
					String[] idStrs = idArray.split(",");
					List<Integer> roleIds = new ArrayList<Integer>();
					for(String idStr : idStrs) {
						roleIds.add(Integer.parseInt(idStr));
					}
					if (sGroupActionName.equals("delete")) {
						int result=adminRoleManageService.deleteRoleIds(roleIds);
						if(Constants.SUCCESS==result) {
							data.put("sStatus", "OK");
							data.put("sMessage", roleIds.size() + "条记录已被删除");
						}
					}
				}
			}
			//筛选
			else if(DTConstants.FILTER_ACTION.equals(sAction)){
				//接收前台datatables的筛选条件.
				
				String roleName = request.getParameter("roleName").trim();
				String roleDescribe = request.getParameter("roleDescribe").trim();
				String roleUseStatus = request.getParameter("roleUseStatus").trim();
				String roleType = request.getParameter("roleType").trim();
				if(StringUtils.isNotEmpty(roleName)){
					map.put("roleName", roleName);
				}
				if(StringUtils.isNotEmpty(roleDescribe)){
					map.put("roleDescribe",roleDescribe);
				}
				if(StringUtils.isNotEmpty(roleType)){
					map.put("roleType", Byte.parseByte(roleType));
				}
				if(StringUtils.isNotEmpty(roleUseStatus)){
					map.put("parentDepaName", Byte.parseByte(roleUseStatus));
				}
			}
		}
		PageContext pageContext = PageUtil.setPageArgs(iDisplayStart, iDisplayLength, iTotalRows);
		List<Map<String, Object>> list=adminRoleManageService.getRoleList(map);
		data.put(DTConstants.ECHO, sEcho);
		data.put(DTConstants.TOTAL_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.TOTAL_DISPLAY_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.DATA, list);
		return data;
	}
	
}
