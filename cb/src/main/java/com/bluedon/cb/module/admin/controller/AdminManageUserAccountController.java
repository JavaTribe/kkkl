/*
 * Copyright (c) 2015 
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.module.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluedon.cb.common.entity.Role;
import com.bluedon.cb.common.entity.UserBasic;
import com.bluedon.cb.common.entity.UserRole;
import com.bluedon.cb.common.pojo.DepartmentTree;
import com.bluedon.cb.module.admin.service.AdminManageUserAccountService;
import com.bluedon.cb.util.DepartmentTreeUtil;
import com.bluedon.cb.util.PageUtil;
import com.bluedon.cb.util.constants.Constants;
import com.bluedon.cb.util.constants.DTConstants;
import com.bluedon.cb.util.constants.StatusConstants;
import com.bluedon.cb.util.paging.PageContext;

/**
 * Description:管理普通用户账号
 * Time:2015年12月4日下午4:18:35
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Controller
@RequestMapping("/admin/manageUserAccount")
public class AdminManageUserAccountController {
	
	/** 用户角色状态为启用 */
	private static final byte OPEN = 2;
	/** 用户角色状态为未启用 */
	private static final byte CLOSE = 0;
	
	@Resource
	private AdminManageUserAccountService adminManageUserAccountService;
	
	
	@RequestMapping("/toUserAccountList")
	public String toUserAccountList(Model model){
		return "admin/manageuseraccount/user_account_list";
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
	@RequestMapping("/getUserAccountList")
	@ResponseBody
	public Map<String, Object> getUserAccountList(HttpServletRequest request, String sEcho, 
			String iDisplayStart, String iDisplayLength, String iTotalRows, String sAction,String sGroupActionName ) {
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
					List<Integer> usbaIds = new ArrayList<Integer>();
					for(String idStr : idStrs) {
						usbaIds.add(Integer.parseInt(idStr));
					}
					
					if(StringUtils.equals("start", sGroupActionName)){	//启用
						try{
							int num = adminManageUserAccountService.updateUserBasicEnableByUsbaIds(usbaIds, StatusConstants.OPEN);
							data.put("sStatus", "OK");
							data.put("sMessage", num + "条记录已启用");
						}catch(Exception e){
							e.printStackTrace();
							data.put("sMessage", "启用失败，请重试...");
						}
					}else if(StringUtils.equals("disable", sGroupActionName)){ //禁用
						try{
							int num = adminManageUserAccountService.updateUserBasicEnableByUsbaIds(usbaIds, StatusConstants.CLOSE);
							data.put("sStatus", "OK");
							data.put("sMessage", num + "条记录已禁用");
						}catch(Exception e){
							e.printStackTrace();
							data.put("sMessage", "禁用失败，请重试...");
						}
					}else if (sGroupActionName.equals("delete")) { //删除
						try{
							int num = adminManageUserAccountService.removeUserBasicByUsbaId(usbaIds);
							data.put("sStatus", "OK");
							data.put("sMessage", num + "条记录已删除");
						}catch(Exception e){
							e.printStackTrace();
							data.put("sMessage", "删除失败，请重试...");
						}
					}
				}
			}
			//筛选
			else if(DTConstants.FILTER_ACTION.equals(sAction)){
				//接收前台datatables的筛选条件.
				
				String depaName = request.getParameter("depa_name").trim();
				String tebaNo = request.getParameter("teba_no").trim();
				String tebaName = request.getParameter("teba_name").trim();
				String tebaProfessionalTitle = request.getParameter("teba_professional_title").trim();
				String tebaDegree = request.getParameter("teba_degree").trim();
				String tebaPosition = request.getParameter("teba_position").trim();
				String tebaAccountLocked = request.getParameter("teba_account_locked").trim();
				String tebaAccountEnable = request.getParameter("teba_account_enable").trim();
				String tebaAttribute4 = request.getParameter("teba_attribute_4").trim();
				if(StringUtils.isNotEmpty(depaName)){
					map.put("depaName", depaName);
				}
				if(StringUtils.isNotEmpty(tebaNo)){
					map.put("tebaNo", tebaNo);
				}
				if(StringUtils.isNotEmpty(tebaName)){
					map.put("tebaName", tebaName);
				}
				if(StringUtils.isNotEmpty(tebaProfessionalTitle)){
					map.put("tebaProfessionalTitle",tebaProfessionalTitle);
				}
				if(StringUtils.isNotEmpty(tebaDegree)){
					map.put("tebaDegree", tebaDegree);
				}
				if(StringUtils.isNotEmpty(tebaPosition)){
					map.put("tebaPosition", tebaPosition);
				}
				if(StringUtils.isNotEmpty(tebaAccountLocked)){
					map.put("tebaAccountLocked", Byte.parseByte(tebaAccountLocked));
				}
				if(StringUtils.isNotEmpty(tebaAccountEnable)){
					map.put("tebaAccountEnable", Byte.parseByte(tebaAccountEnable));
				}
				if(StringUtils.isNotEmpty(tebaAttribute4)){
					map.put("tebaAttribute4", tebaAttribute4);
				}
			}
		}
		PageContext pageContext = PageUtil.setPageArgs(iDisplayStart, iDisplayLength, iTotalRows);
		List<Map<String, Object>> list=adminManageUserAccountService.getUserAccountList(map);
		data.put(DTConstants.ECHO, sEcho);
		data.put(DTConstants.TOTAL_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.TOTAL_DISPLAY_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.DATA, list);
		return data;
	}
	

	
	
	
	/**
	 * 跳转到用户账号编辑的页面.
	 * @param usbaId
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditUserAccount/{usbaId}")
	public String toEditUserAccount(@PathVariable("usbaId") int usbaId, Model model){
		Map<String, Object> userDetails = adminManageUserAccountService.getUserDetailsByUsbaId(usbaId);
		int gradId = (Integer) userDetails.get("grad_id");
		int depaId = (Integer) userDetails.get("depa_id");
		List<DepartmentTree> departmentTrees = new ArrayList<DepartmentTree>();
		if(gradId == Constants.GRAD_SECOND){
			DepartmentTree departmentTree = DepartmentTreeUtil.getParent(depaId);
			departmentTrees = DepartmentTreeUtil.getGradeDepartmentTrees(departmentTree.getDepaId(), Constants.GRAD_SECOND);
			departmentTrees.add(0, departmentTree);
		}else if(gradId == Constants.GRAD_FIRST){
			DepartmentTree departmentTree = DepartmentTreeUtil.getDepartmentTreeByDepaId(depaId);
			departmentTrees = DepartmentTreeUtil.getGradeDepartmentTrees(depaId, Constants.GRAD_SECOND);
			departmentTrees.add(0, departmentTree);
		}

		model.addAttribute("userDetails", userDetails);
		model.addAttribute("departmentTrees", departmentTrees);
		
		return "admin/manageuseraccount/edit_user_account";
	}
	
	/**
	 * 跳转到用户角色管理页面.
	 * @param usbaId
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditUserRole/{usbaId}")
	public String toEditUserRole(@PathVariable("usbaId") int usbaId, HttpSession session, Model model){
		Map<String, Object> userDetails = adminManageUserAccountService.getUserDetailsByUsbaId(usbaId);
		
		int gradId = (Integer) userDetails.get("grad_id");
		int depaId = (Integer) userDetails.get("depa_id");
		
		List<Byte> roleTypes = new ArrayList<Byte>();
		List<Role> roles = adminManageUserAccountService.getRoleByRoleTypes(roleTypes);
		
		List<DepartmentTree> departmentTrees = new ArrayList<DepartmentTree>();
		if(gradId == Constants.GRAD_SECOND){
			DepartmentTree departmentTree = DepartmentTreeUtil.getDepartmentTreeByDepaId(depaId);
			departmentTrees = DepartmentTreeUtil.getGradeDepartmentTrees(departmentTree.getDepaId(), Constants.GRAD_THIRD);
			departmentTrees.add(0, departmentTree);
		}else if(gradId == Constants.GRAD_FIRST){
			DepartmentTree departmentTree = DepartmentTreeUtil.getDepartmentTreeByDepaId(depaId);
			departmentTrees.add(0, departmentTree);
		}
		
		model.addAttribute("userDetails", userDetails);
		model.addAttribute("departmentTrees", departmentTrees);
		model.addAttribute("roles", roles);
		return "admin/manageuseraccount/edit_user_role";
	}
	
	/**
	 * 重置用户的账号密码.
	 * @param usbaId
	 * @return
	 */
	@RequestMapping("/resetUserAccountPassword")
	@ResponseBody
	public Map<String, Object> resetUserAccountPassword(int usbaId){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			int success = adminManageUserAccountService.updateUserAccountPasswordByUsbaId(usbaId, Constants.RESET_PASSWORD);
			if(success == 1){
				map.put("sStatus", true);
				map.put("sMessage", "重置密码成功");
			}
			else{
				map.put("sStatus", false);
				map.put("sMessage", "重置密码失败,请重新...");
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("sStatus", false);
			map.put("sMessage", "重置密码失败,请重新...");
		}
		
		return map;
	}
	
	/**
	 * 更新用户账号信息.
	 * @param usbaId
	 * @param tebaNo
	 * @param tebaName
	 * @param tebaAccountEnable
	 * @param tebaAccountLocked
	 * @param depaId
	 * @param tebaAttribute4
	 * @return
	 */
	@RequestMapping("/updateUserAccount")
	public String updateUserAccount(int usbaId, String tebaNo, String tebaName, byte tebaAccountEnable,
			byte tebaAccountLocked, int depaId, String tebaAttribute4){
		try{
			int success = adminManageUserAccountService.updateUserAccountByUsbaId(usbaId, tebaNo,
					tebaName, tebaAccountEnable, tebaAccountLocked, depaId, tebaAttribute4);
//			if(success<1){
//				return "redirect:/common/error/updateUserAccountError?code="+ErrorCodeConstants.E11_UPDATE_USER_FAILURE;
//			}
		}catch(Exception e){
			e.printStackTrace();
			//return "redirect:/common/error/updateUserAccountError?code="+ErrorCodeConstants.E11_UPDATE_USER_FAILURE;
		}
		return "admin/manageuseraccount/user_account_list";
	}
	
	/**
	 * 跳转到添加用户账号的页面.
	 * @param model model.
	 * @return
	 */
	@RequestMapping("/toAddUserAccount")
	public String toAddUserAccount(Model model){
		DepartmentTree departmentTree = DepartmentTreeUtil.getDepartmentTree();
		model.addAttribute("departmentTree", departmentTree);
		return "admin/manageuseraccount/add_user_account";
	}
	
	/**
	 * 添加用户.
	 * @param userBasic
	 * @return
	 */
	@RequestMapping("/addNewUserAccount")
	public String addNewUserAccount(UserBasic userBasic){
		UserBasic UserBasic = adminManageUserAccountService.getUserBasicByUserName(userBasic.getUsbaAccount());
//		if(null != teba){
//			return "redirect:/common/error/addUserAccountError?code="+ErrorCodeConstants.E12_USER_EXIST; //账号已存在
//		}
//		try{
//			int success = adminManageUserAccountService.addUserBasic(userBasic);
//			if(success <= 0){
//				return "redirect:/common/error/addUserAccountError?code="+ErrorCodeConstants.E12_ADD_USER_FAILURE;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			return "redirect:/common/error/addUserAccountError?code="+ErrorCodeConstants.E12_ADD_USER_FAILURE;
//		}
		return "admin/manageuseraccount/user_account_list";
	}
	
	/**
	 * 启用所有的用户账号.
	 * @return
	 */
	@RequestMapping("/activateAllUserAccount")
	@ResponseBody	
	public Map<String, Object> activateAllUserAccount(){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			int num = adminManageUserAccountService.updateUserBasicEnableByUsbaIds(null, StatusConstants.OPEN);
			map.put("sStatus", true);
			map.put("sMessage", "操作成功");
		}catch(Exception e){
			e.printStackTrace();
			map.put("sStatus", false);
			map.put("sMessage", "操作失败，请重试...");
		}
		
		return map;
	}
	
	@RequestMapping("/getUserRoleList/{usbaId}")
	@ResponseBody
	public Map<String, Object> getUserRoleList(@PathVariable("usbaId") int usbaId, HttpServletRequest request, String sEcho, 
			String iDisplayStart, String iDisplayLength, String iTotalRows, String sAction,String sGroupActionName){	
		Map<String, Object> data = new HashMap<String, Object>();
		
		if(StringUtils.equals(sAction, DTConstants.GROUP_ACTION)){
			String idArray = request.getParameter("idArarry");
			if (idArray != null) {
				// 分割为id数组
				String[] idStrs = idArray.split(",");
				List<Integer> usroIds = new ArrayList<Integer>();
				for(String idStr : idStrs) {
					usroIds.add(Integer.parseInt(idStr));
				}
				
				if(StringUtils.equals("start", sGroupActionName)){	//启用
					try{
						int num = adminManageUserAccountService.updateUserRoleStatusByUsroIds(usroIds, OPEN);
						data.put("sStatus", "OK");
						data.put("sMessage", num + "条记录已启用");
					}catch(Exception e){
						e.printStackTrace();
						data.put("sMessage", "启用失败，请重试...");
					}
				}else if(StringUtils.equals("disable", sGroupActionName)){ //禁用
					try{
						int num = adminManageUserAccountService.updateUserRoleStatusByUsroIds(usroIds, CLOSE);
						data.put("sStatus", "OK");
						data.put("sMessage", num + "条记录已禁用");
					}catch(Exception e){
						e.printStackTrace();
						data.put("sMessage", "禁用失败，请重试...");
					}
				}else if (sGroupActionName.equals("delete")) { //删除
					try{
						int num = adminManageUserAccountService.removeUserRoleByUsroIds(usroIds);
						data.put("sStatus", "OK");
						data.put("sMessage", num + "条记录已删除");
					}catch(Exception e){
						e.printStackTrace();
						data.put("sMessage", "删除失败，请重试...");
					}
				}
			}
		}
		
		PageContext pageContext = PageUtil.setPageArgs(iDisplayStart, iDisplayLength, iTotalRows);
		List<Map<String, Object>> list = adminManageUserAccountService.getUserRoleByUsbaId(usbaId);
		data.put(DTConstants.ECHO, sEcho);
		data.put(DTConstants.TOTAL_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.TOTAL_DISPLAY_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.DATA, list);
		return data;
	}
	
	@RequestMapping("/addUserRole")
	@ResponseBody
	public String addUserRole(int usbaId, int roleId,  byte usroStatus){
		UserRole userRole = new UserRole();
		userRole.setUsbaId(usbaId);
		userRole.setRoleId(roleId);
		userRole.setUsroStatus(usroStatus);
		userRole.setUsroCreateDate(new Date());
		try{
			adminManageUserAccountService.addUserRole(userRole);
		}catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
		return "success";
	}
}
