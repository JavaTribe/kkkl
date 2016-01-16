/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.util.constants;


/**
 * Description:jquery-datatables常量类
 * Time:2015年12月3日上午8:36:47
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class DTConstants {
	
	//ajax-datatable在服务器返回前端的参数名称
	public static final String ECHO = "sEcho";
	public static final String TOTAL_RECORDS = "iTotalRecords";
	public static final String TOTAL_DISPLAY_RECORDS = "iTotalDisplayRecords";
	public static final String DATA = "aaData";
	public static final String ACTION = "sAction";
	public static final String MESSAGE = "sMessage";
	public static final String STATUS = "sStatus";
	public static final String USER_TASK_ID = "userTaskId";
	public static final String LAST_ID = "lastId";
	
	//ajax-datatable在服务器返回前端的sAction参数值
	public static final String GROUP_ACTION = "group_action";
	public static final String FILTER_ACTION = "filter";
	public static final String FILTER_CANCEL_ACTION = "filter_cancel";
	public static final String OK = "OK";
	
	//ajax-datatable在服务器接收前端的参数名称
	public static final String ID_ARRAY = "idArarry";
	public static final String GROUP_ACTION_NAME = "sGroupActionName";
	
	//ajax-datatable在服务器接收前端的sGroupActionName参数值
	public static final String SUBMIT = "submit";
	public static final String DELETE = "delete";
	public static final String PASS = "pass";
	public static final String ROLLBACK = "rollback";
	public static final String CANCEL = "cancel";
}
