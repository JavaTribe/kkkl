/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * Description:管理员角色
 * Time:2015年12月2日上午11:33:31
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class AdminRole implements Serializable{
    private static final long serialVersionUID = 8575581064279862063L;

	private Integer adroId;

    private Integer admiId;

    private Integer roleId;

    private Date adroModifyDate;

    private Date adroCreateDate;
    /** 管理员. */
    private Administrator adroAdminstrator;
    
    /** 角色. */
    private Role adroRole;
    public Integer getAdroId() {
        return adroId;
    }

    public void setAdroId(Integer adroId) {
        this.adroId = adroId;
    }

    public Integer getAdmiId() {
        return admiId;
    }

    public void setAdmiId(Integer admiId) {
        this.admiId = admiId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getAdroModifyDate() {
        return adroModifyDate;
    }

    public void setAdroModifyDate(Date adroModifyDate) {
        this.adroModifyDate = adroModifyDate;
    }

    public Date getAdroCreateDate() {
        return adroCreateDate;
    }

    public void setAdroCreateDate(Date adroCreateDate) {
        this.adroCreateDate = adroCreateDate;
    }

	public Administrator getAdroAdminstrator() {
		return adroAdminstrator;
	}

	public void setAdroAdminstrator(Administrator adroAdminstrator) {
		this.adroAdminstrator = adroAdminstrator;
	}

	public Role getAdroRole() {
		return adroRole;
	}

	public void setAdroRole(Role adroRole) {
		this.adroRole = adroRole;
	}

}