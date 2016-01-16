/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:角色对应的模块
 * Time:2015年12月2日上午11:34:47
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class RoleModule implements Serializable{
    private static final long serialVersionUID = -4146650570401802397L;

	private Integer romoId;

    private Integer moduId;

    private Integer roleId;

    private Date romoModifyDate;

    private Date romoCreateDate;
    /** 扩展属性 */
    private String exModuResource;

    public Integer getRomoId() {
        return romoId;
    }

    public void setRomoId(Integer romoId) {
        this.romoId = romoId;
    }

    public Integer getModuId() {
        return moduId;
    }

    public void setModuId(Integer moduId) {
        this.moduId = moduId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getRomoModifyDate() {
        return romoModifyDate;
    }

    public void setRomoModifyDate(Date romoModifyDate) {
        this.romoModifyDate = romoModifyDate;
    }

    public Date getRomoCreateDate() {
        return romoCreateDate;
    }

    public void setRomoCreateDate(Date romoCreateDate) {
        this.romoCreateDate = romoCreateDate;
    }

	public String getExModuResource() {
		return exModuResource;
	}

	public void setExModuResource(String exModuResource) {
		this.exModuResource = exModuResource;
	}
}