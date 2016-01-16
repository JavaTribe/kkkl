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

import com.bluedon.cb.common.entity.ParentModule;
import com.bluedon.cb.common.mapper.ParentModuleMapper;
import com.bluedon.cb.module.admin.service.AdminParentModuleManageService;
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
@RequestMapping("/admin/parentModuleManage")
public class AdminParentModuleManageController {
	
	@Resource
	private AdminParentModuleManageService adminParentModuleManageService;
	
	@Resource
	private ParentModuleMapper parentModuleMapper;
	
	@RequestMapping("toParentModuleManageList")
	public String toParentModuleManageList() {
		return "admin/parentmodulemanage/parent_module_manage_list";
	}
	
	@RequestMapping("/toParentModuleManageAddOREdit")
	public String toModuleManageAddOREdit(Model model,HttpServletRequest request){
		
		String pamoId=request.getParameter("pamoId");
		if(StringUtils.isNotBlank(pamoId)) {//编辑
			ParentModule parentModule=parentModuleMapper.selectByPrimaryKey(Integer.parseInt(pamoId));
			model.addAttribute("parentModule", parentModule);
		}
		
		return "admin/parentmodulemanage/parent_module_manage_add_edit";
	}
	
	@RequestMapping("saveParentModule")
	@ResponseBody
	public String saveParentModule(HttpServletRequest request,ParentModule parentModule){
		int result;
		if(parentModule.getPamoId()!=null){//更新
			result=adminParentModuleManageService.updateParentModuleByPrimaryKeySelective(parentModule);
		}else {//新建
			result=adminParentModuleManageService.insertParentModule(parentModule);
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
	 * @return 父模块列表.
	 */
	@RequestMapping("/getParentModuleManageList")
	@ResponseBody
	public Map<String, Object> getParentModuleManageList(HttpServletRequest request, String sEcho, String iDisplayStart, String iDisplayLength, String iTotalRows, String sAction,String sGroupActionName ) {
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
					List<Integer> pamoIds = new ArrayList<Integer>();
					for(String idStr : idStrs) {
						pamoIds.add(Integer.parseInt(idStr));
					}
					if (sGroupActionName.equals("delete")) {
						result=adminParentModuleManageService.deleteParentModuleByIds(pamoIds);
						if(Constants.SUCCESS==result) {
							data.put("sStatus", "OK");
							data.put("sMessage", pamoIds.size() + "条记录已被删除");
						}
					}else if(sGroupActionName.equals("open")){//启用
						result=adminParentModuleManageService.updateParentModuleByIds(pamoIds, StatusConstants.OPEN);
						if(Constants.SUCCESS==result) {
							data.put("sStatus", "OK");
							data.put("sMessage", pamoIds.size() + "条记录已被启用");
						}
					}else {//关闭
						result=adminParentModuleManageService.updateParentModuleByIds(pamoIds, StatusConstants.CLOSE);
						if(Constants.SUCCESS==result) {
							data.put("sStatus", "OK");
							data.put("sMessage", pamoIds.size() + "条记录已被关闭");
						}
						
					}
				}
			}
			//筛选
			else if(DTConstants.FILTER_ACTION.equals(sAction)){
				//接收前台datatables的筛选条件.
				
				String pamoName = request.getParameter("pamo_name").trim();
				String pamoDescribe = request.getParameter("pamo_describe").trim();
				String pamoSort = request.getParameter("pamo_sort").trim();
				String pamoUseStatus = request.getParameter("pamo_use_status").trim();
				String pamoIcon = request.getParameter("pamo_icon").trim();
				if(StringUtils.isNotEmpty(pamoName)){
					map.put("pamoName", pamoName);
				}
				if(StringUtils.isNotEmpty(pamoDescribe)){
					map.put("pamoDescribe",pamoDescribe);
				}
				if(StringUtils.isNotEmpty(pamoSort)){
					map.put("pamoSort", Byte.parseByte(pamoSort));
				}
				if(StringUtils.isNotEmpty(pamoUseStatus)){
					map.put("pamoUseStatus", Byte.parseByte(pamoUseStatus));
				}
				if(StringUtils.isNotEmpty(pamoIcon)){
					map.put("pamoIcon",pamoIcon);
				}
			}
		}
		PageContext pageContext = PageUtil.setPageArgs(iDisplayStart, iDisplayLength, iTotalRows);
		List<Map<String, Object>> list=adminParentModuleManageService.getParentModuleList(map);
		data.put(DTConstants.ECHO, sEcho);
		data.put(DTConstants.TOTAL_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.TOTAL_DISPLAY_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.DATA, list);
		return data;
	}

}
