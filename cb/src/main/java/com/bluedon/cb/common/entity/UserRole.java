/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:用户角色
 * Time:2015年12月2日上午11:35:27
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class UserRole implements Serializable{
    private static final long serialVersionUID = 7574160378991524940L;

	private Integer usroId;

    private Integer roleId;

    private Integer usbaId;

    private Date usroModifyDate;

    private Date usroCreateDate;

    private Byte usroStatus;

    /** 用户基本信息. */
    private UserBasic usroUserBasic;
	/** 角色. */
    private Role usroRole;
    
    /**
	 * getter method
	 * @return the usroUserBasic
	 */
	
	public UserBasic getUsroUserBasic() {
		return usroUserBasic;	
	}

	/**
	 * setter method
	 * @param usroUserBasic the usroUserBasic to set
	 */
	
	public void setUsroUserBasic(UserBasic usroUserBasic) {
		this.usroUserBasic = usroUserBasic;
	}

	/**
	 * getter method
	 * @return the usroRole
	 */
	
	public Role getUsroRole() {
		return usroRole;
	}

	/**
	 * setter method
	 * @param usroRole the usroRole to set
	 */
	
	public void setUsroRole(Role usroRole) {
		this.usroRole = usroRole;
	}


    
    public Integer getUsroId() {
        return usroId;
    }

    public void setUsroId(Integer usroId) {
        this.usroId = usroId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUsbaId() {
        return usbaId;
    }

    public void setUsbaId(Integer usbaId) {
        this.usbaId = usbaId;
    }

    public Date getUsroModifyDate() {
        return usroModifyDate;
    }

    public void setUsroModifyDate(Date usroModifyDate) {
        this.usroModifyDate = usroModifyDate;
    }

    public Date getUsroCreateDate() {
        return usroCreateDate;
    }

    public void setUsroCreateDate(Date usroCreateDate) {
        this.usroCreateDate = usroCreateDate;
    }

    public Byte getUsroStatus() {
        return usroStatus;
    }

    public void setUsroStatus(Byte usroStatus) {
        this.usroStatus = usroStatus;
    }
}