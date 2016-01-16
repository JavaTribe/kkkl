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

import com.bluedon.cb.common.entity.Module;
import com.bluedon.cb.common.entity.ParentModule;
import com.bluedon.cb.common.mapper.ModuleMapper;
import com.bluedon.cb.module.admin.service.AdminModuleManageService;
import com.bluedon.cb.util.PageUtil;
import com.bluedon.cb.util.constants.Constants;
import com.bluedon.cb.util.constants.DTConstants;
import com.bluedon.cb.util.constants.StatusConstants;
import com.bluedon.cb.util.paging.PageContext;

/**
 * Description		: 
 * 
 * 
 * <br><br>Time		: 2015-11-20  下午3:02:49
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author chenchengteng
 */
@Controller
@RequestMapping("/admin/moduleManage")
public class AdminModuleManageController {
	
	@Resource
	private AdminModuleManageService adminModuleManageService;
	
	@Resource(name="moduleMapper")
	private ModuleMapper moduleMapper;
	
	@RequestMapping("toModuleManageList")
	public String toModuleManageList() {
		return "admin/modulemanage/module_manage_list";
	}
	
	@RequestMapping("/toModuleManageAddOREdit")
	public String toModuleManageAddOREdit(Model model,HttpServletRequest request){
		String moduId=request.getParameter("moduId");
		if(StringUtils.isNotBlank(moduId)){
			Module module=moduleMapper.selectByPrimaryKey(Integer.parseInt(moduId));
			model.addAttribute("module", module);
		}
		List<ParentModule> parentModules=adminModuleManageService.getParentModules();
		model.addAttribute("parentModules", parentModules);
		return "admin/modulemanage/module_manage_add_edit";
	}
	
	@RequestMapping("saveModule")
	@ResponseBody
	public String saveModule(HttpServletRequest request,Module module){
		int result;
		if(null!=module.getModuId()){//更新
			result=adminModuleManageService.updateModuleByPrimaryKeySelective(module);
		}else {//新建
			result=adminModuleManageService.insertModule(module);
		}
		if(result==Constants.SUCCESS){
			return "success";
		}else {
			return "操作失败";
		}
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
	@RequestMapping("/getModuleManageList")
	@ResponseBody
	public Map<String, Object> getModuleManageList(HttpServletRequest request, String sEcho, String iDisplayStart, String iDisplayLength, String iTotalRows, String sAction,String sGroupActionName ) {
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
					int result;
					List<Integer> moduIds = new ArrayList<Integer>();
					for(String idStr : idStrs) {
						moduIds.add(Integer.parseInt(idStr));
					}
					if (sGroupActionName.equals("delete")) {
						result=adminModuleManageService.deleteModuleByIds(moduIds);
						if(Constants.SUCCESS==result) {
							data.put("sStatus", "OK");
							data.put("sMessage", moduIds.size() + "条记录已被删除");
						}
					}else if(sGroupActionName.equals("open")){//启用
						result=adminModuleManageService.updateModuleByIds(moduIds, StatusConstants.OPEN);
						if(Constants.SUCCESS==result) {
							data.put("sStatus", "OK");
							data.put("sMessage", moduIds.size() + "条记录已被启用");
						}
					}else {//关闭
						result=adminModuleManageService.updateModuleByIds(moduIds, StatusConstants.CLOSE);
						if(Constants.SUCCESS==result) {
							data.put("sStatus", "OK");
							data.put("sMessage", moduIds.size() + "条记录已被关闭");
						}
						
					}
				}
			}
			//筛选
			else if(DTConstants.FILTER_ACTION.equals(sAction)){
				//接收前台datatables的筛选条件.
				
				String moduName = request.getParameter("modu_name").trim();
				String pamoName = request.getParameter("pamo_name").trim();
				String moduUrl = request.getParameter("modu_url").trim();
				String moduResource = request.getParameter("modu_resource").trim();
				String moduUseStatus = request.getParameter("modu_use_status").trim();
				String moduSort = request.getParameter("modu_sort").trim();
				
				if(StringUtils.isNotEmpty(moduName)){
					map.put("moduName", moduName);
				}
				if(StringUtils.isNotEmpty(pamoName)){
					map.put("pamoName",pamoName);
				}
				if(StringUtils.isNotEmpty(moduUrl)){
					map.put("moduUrl",moduUrl);
				}
				if(StringUtils.isNotEmpty(moduResource)){
					map.put("moduResource",moduResource);
				}
				if(StringUtils.isNotEmpty(moduUseStatus)){
					map.put("moduUseStatus", Byte.parseByte(moduUseStatus));
				}
				if(StringUtils.isNotEmpty(moduSort)){
					map.put("moduSort", Byte.parseByte(moduSort));
				}
			}
		}
		PageContext pageContext = PageUtil.setPageArgs(iDisplayStart, iDisplayLength, iTotalRows);
		List<Map<String, Object>> list=adminModuleManageService.getModuleList(map);
		data.put(DTConstants.ECHO, sEcho);
		data.put(DTConstants.TOTAL_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.TOTAL_DISPLAY_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.DATA, list);
		return data;
	}

}
