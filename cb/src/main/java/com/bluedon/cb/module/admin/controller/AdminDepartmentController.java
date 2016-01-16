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

import com.bluedon.cb.common.entity.Department;
import com.bluedon.cb.common.entity.Grade;
import com.bluedon.cb.module.admin.service.AdminDepartmentService;
import com.bluedon.cb.module.admin.service.AdminGradeService;
import com.bluedon.cb.util.PageUtil;
import com.bluedon.cb.util.constants.DTConstants;
import com.bluedon.cb.util.log.ControllerLogAnnotation;
import com.bluedon.cb.util.paging.PageContext;


/**
 * Description		: 部门Controller.
 * 
 * 
 * <br><br>Time		: 2015-11-20  上午11:23:55
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author CCT
 */
@Controller
@RequestMapping("/admin/department")
public class AdminDepartmentController {
	
	
	@Resource
	private AdminGradeService adminGradeService;
	
	@Resource
	private AdminDepartmentService adminDepartmentService;
	
	@RequestMapping("/toDepartmentList")
	public String toDepartmentList(Model model){
		return "admin/department/department_list";
	}
	
	/**
	 * @param model
	 * @param request
	 * @return 新建或者编辑Model.
	 */
	@RequestMapping("/toAddOrEidtDepartment")
	@ControllerLogAnnotation(description = "查询用户")
	public String toAddOrEidtDepartment(Model model,HttpServletRequest request) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		PageContext.getContext().setPagination(false);
		List<Grade> gradeList =adminGradeService.getGradeList(map);
		String depaId=request.getParameter("depaId");
		if(StringUtils.isNotBlank(depaId)){
			Department department=adminDepartmentService.getDepartmentByDepaId(Integer.parseInt(depaId));
			model.addAttribute("department",department);
		}
		List<Map<String, Object>> departmentMenuList =adminDepartmentService.getDepartmentMenu();
		model.addAttribute("gradeList",gradeList);
		model.addAttribute("departmentMenuList",departmentMenuList);
		return "admin/department/department_add_edit";
		
	}
	

	
	/**
	 * 更新或者插入新的部门.
	 * @param request
	 * @return 操作结果
	 */
	@RequestMapping("/saveDepartment")
	@ResponseBody
	@ControllerLogAnnotation(description = "查询用户")
	public String saveDepartment(HttpServletRequest request){
		Department department=new Department();
		String result ;
		String grade=request.getParameter("grade").trim();
		String depaId=request.getParameter("depa_id");
		String depaNo=request.getParameter("depaNo").trim();
		String depaName=request.getParameter("depaName").trim();
		String depaDescription=request.getParameter("depaDescription").trim();
		
		//级别Id
		int gradId=Integer.parseInt(grade.split("%")[0]);
		//级别编号
		int gradNo=Integer.parseInt(grade.split("%")[1]);
		int depDepaId ;
		department.setDepaNo(depaNo);
		department.setDepaName(depaName);
		department.setDepaDescription(depaDescription);
		department.setGradId(gradId);
		
		if(gradNo>1){
			String parentIdStr=request.getParameter(""+(gradNo-1));
			//判断是否存在父部门
			if(StringUtils.isNotBlank(parentIdStr)){
				depDepaId=Integer.parseInt(parentIdStr.trim());
				department.setDepDepaId(depDepaId);
			}else{
				result="父部门不为空";
				return result;
			}
		}else {
			
			Department topDepartment=adminDepartmentService.getTopDepartment();
			if(topDepartment!=null){//判断是否已经存在顶级部门
				if(StringUtils.isNotBlank(depaId)){
					if(Integer.parseInt(depaId)!=topDepartment.getDepaId().intValue()){//判断是否是新建顶级部门
						result="不能存在多个顶级部门";
						return result;
					}
				}
			}
		}
		if(StringUtils.isNotBlank(depaId)){
			//更新操作
			try {
				department.setDepaId(Integer.parseInt(depaId.trim()));
				adminDepartmentService.updateDepartment(department);
				return "success";
			} catch (Exception e) {
				return "部门编号重复";
			}
		}else{
			//插入操作
			try {
				adminDepartmentService.addDepartment(department);
				return "success";
			} catch (Exception e) {
				return "部门编号重复";
			}
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
	 * @return 部门列表.
	 */
	@RequestMapping("/getDepartmentList")
	@ResponseBody
	@ControllerLogAnnotation(description = "查询用户")
	public Map<String, Object> getDepartmentList(HttpServletRequest request, String sEcho, String iDisplayStart, String iDisplayLength, String iTotalRows, String sAction,String sGroupActionName ) {
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
					List<Integer> depaIds = new ArrayList<Integer>();
					for(String idStr : idStrs) {
						depaIds.add(Integer.parseInt(idStr));
					}
					if (sGroupActionName.equals("delete")) {
						int upNum = adminDepartmentService.batchDeleteDepartment(depaIds);
						if(upNum > 0) {
							data.put("sStatus", "OK");
							data.put("sMessage", upNum + "条记录已被删除");
						}
					}
				}
			}
			//筛选
			else if(DTConstants.FILTER_ACTION.equals(sAction)){
				//接收前台datatables的筛选条件.
				
				String depaName = request.getParameter("depa_name").trim();
				String depaNo = request.getParameter("depa_no").trim();
				String gradGradeName = request.getParameter("grad_grade_name").trim();
				String parentDepaName = request.getParameter("parent_depa_name").trim();
				String parentDepaNo = request.getParameter("parent_depa_no").trim();
				if(StringUtils.isNotEmpty(depaName)){
					map.put("depaName", depaName);
				}
				if(StringUtils.isNotEmpty(depaNo)){
					map.put("depaNo",depaNo);
				}
				if(StringUtils.isNotEmpty(gradGradeName)){
					map.put("gradGradeName", gradGradeName);
				}
				if(StringUtils.isNotEmpty(parentDepaName)){
					map.put("parentDepaName", parentDepaName);
				}
				if(StringUtils.isNotEmpty(parentDepaNo)){
					map.put("parentDepaNo", parentDepaNo);
				}
			}
		}
		PageContext pageContext = PageUtil.setPageArgs(iDisplayStart, iDisplayLength, iTotalRows);
		List<Map<String, Object>> list=adminDepartmentService.getDepartmentList(map);
		data.put(DTConstants.ECHO, sEcho);
		data.put(DTConstants.TOTAL_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.TOTAL_DISPLAY_RECORDS, pageContext.getTotalRows());
		data.put(DTConstants.DATA, list);
		return data;
	}
	
	
}
