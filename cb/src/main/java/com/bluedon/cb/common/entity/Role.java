/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:角色
 * Time:2015年12月2日上午11:34:39
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class Role  implements Serializable{
    private static final long serialVersionUID = 8045163468131586561L;

	private Integer roleId;

    private String roleName;

    private Byte roleType;

    private String roleDescribe;

    private Date roleModifyDate;

    private Date roleCreateDate;

    private Byte roleSort;

    private Byte roleUseStatus;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Byte getRoleType() {
        return roleType;
    }

    public void setRoleType(Byte roleType) {
        this.roleType = roleType;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    public Date getRoleModifyDate() {
        return roleModifyDate;
    }

    public void setRoleModifyDate(Date roleModifyDate) {
        this.roleModifyDate = roleModifyDate;
    }

    public Date getRoleCreateDate() {
        return roleCreateDate;
    }

    public void setRoleCreateDate(Date roleCreateDate) {
        this.roleCreateDate = roleCreateDate;
    }

    public Byte getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Byte roleSort) {
        this.roleSort = roleSort;
    }

    public Byte getRoleUseStatus() {
        return roleUseStatus;
    }

    public void setRoleUseStatus(Byte roleUseStatus) {
        this.roleUseStatus = roleUseStatus;
    }
}