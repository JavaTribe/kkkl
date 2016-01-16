/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.util.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bluedon.cb.util.constants.Constants;

/**
 * Description:获取session属性
 * Time:2015年12月2日下午6:03:39
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class SessionPropertyUtil {
	
	/**
	  * @Description: 获取普通用户角色Id
	  * @return usroId
	  */
	public static Integer getUsroId() {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Object object = req.getSession().getAttribute(Constants.USER_ROLE_ID);
		if(object == null) {
			return null;
		} else {
			return (Integer) object;
		}
	}
	
	/**
	  * @Description: 获取管理员角色Id
	  * @return adroId
	  */
	public static Integer getAdroId() {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Object object = req.getSession().getAttribute(Constants.ADMIN_ROLE_ID);
		
		if(object == null) {
			return null;
		} else {
			return (Integer) object;
		}
	}
	
	/**
	  * @Description: 获取sessionId
	  * @return 
	  */
	public static String getSessionId() {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Object object = req.getSession().getAttribute(Constants.SESSION_ID);
		
		if(object == null) {
			return null;
		} else {
			return (String) object;
		}
	}
	
	/**
	  * @Description: 获取角色Id
	  * @return
	  */
	public static Integer getRoleId() {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Object object = req.getSession().getAttribute(Constants.ROLE_ID);
		
		if(object == null) {
			return null;
		} else {
			return (Integer) object;
		}
	}
	
	/**
	  * @Description: 检查是否有登录用户
	  * @return YES返回True，NO返回False
	  */
	public static boolean isLogin() {
		if(getAdroId() != null || getUsroId() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @Description:获取Session中的管理员账号
	 * @return
	 */
	public static String getAdmiAccount(){
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Object object = req.getSession().getAttribute(Constants.ADMI_ACCOUNT);
		
		if(object == null) {
			return null;
		} else {
			return (String) object;
		}
	
	}
	
	/**
	 * @Description:获取Session中的普通用户账号
	 * @return
	 */
	public static String getUserAccount(){
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Object object = req.getSession().getAttribute(Constants.USER_ACCOUNT);
		
		if(object == null) {
			return null;
		} else {
			return (String) object;
		}
	}
	
	/**@Description：获取角色名称
	 * @return
	 */
	public static String getRoleName(){
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Object object = req.getSession().getAttribute(Constants.ROLE_NAME);
		
		if(object == null) {
			return null;
		} else {
			return (String) object;
		}
	}
	
	/**
	 * Description:获取用户访问IP
	 * @return
	 */
	public static String getIP(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getRemoteAddr();
	}
}
