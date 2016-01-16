/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.util.constants;

/**
 * Description:全局的容器常量类
 * Time:2015年12月2日下午5:57:04
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class Constants {

	//操作码 
	/** 操作成功 */
	public static final int SUCCESS = 1;
	/** 操作失败 */
	public static final int FAILURE = 0;
	
	/** 附件上传Webapp下文件夹. */
	public static final String DRIVER_FILE = "/driverFile";
	
	//存放在session中的变量
	public static final String USER_ROLE_ID = "usroId";
	public static final String ADMIN_ROLE_ID = "adroId";
	public static final String ROLE_ID = "roleId";
	public static final String SESSION_ID = "sessionId";
	public static final String ROLE_NAME="roleName";
	public static final String ADMI_ACCOUNT="admiAccount";
	public static final String USER_ACCOUNT="userAccount";
	
	//部门级别
	public static final int GRAD_FIRST = 1;
	public static final int GRAD_SECOND = 2;
	public static final int GRAD_THIRD = 3;
	public static final int GRAD_FOURTH = 4;
	public static final int GRAD_FIFTH = 5;
	public static final int GRAD_SIXTH = 6;
	public static final int GRAD_SEVENTH = 7;
	
	//批量插入时,Map放入初始化ID值
	public static final int FIRST_INSERT_ID=0;
	
	/** 重置密码后的默认密码为666666 */
	public final static String RESET_PASSWORD = "666666";
	
	/** CKFinder的权限控制key */
	public final static String CKFINDER_USERROLE_KEY = "CKFinder_UserRole";
	/** CKFinder的管理员权限value */
	public final static String CKFINDER_USERROLE_ADMIN = "admin";
	
	
	/** maximum number of bytes to read */
	public final static int READ_MAXIMUM = 256;
	
}
