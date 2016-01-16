/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Description:父模块
 * Time:2015年12月2日上午11:34:23
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class ParentModule implements Serializable{
    private static final long serialVersionUID = -5864482237459427501L;

	private Integer pamoId;

    private String pamoName;

    private String pamoDescribe;

    private String pamoIcon;

    private Date pamoModifyDate;

    private Date pamoCreateDate;

    private Byte pamoSort;

    private Byte pamoUseStatus;
    
    /** 父模块.*/
    private ParentModule pamoParentModule;
    
    /**  子模块.*/
    private List<Module> pamoModules;
    
    public Integer getPamoId() {
        return pamoId;
    }

    public void setPamoId(Integer pamoId) {
        this.pamoId = pamoId;
    }

    public String getPamoName() {
        return pamoName;
    }

    public void setPamoName(String pamoName) {
        this.pamoName = pamoName;
    }

    public String getPamoDescribe() {
        return pamoDescribe;
    }

    public void setPamoDescribe(String pamoDescribe) {
        this.pamoDescribe = pamoDescribe;
    }

    public String getPamoIcon() {
        return pamoIcon;
    }

    public void setPamoIcon(String pamoIcon) {
        this.pamoIcon = pamoIcon;
    }

    public Date getPamoModifyDate() {
        return pamoModifyDate;
    }

    public void setPamoModifyDate(Date pamoModifyDate) {
        this.pamoModifyDate = pamoModifyDate;
    }

    public Date getPamoCreateDate() {
        return pamoCreateDate;
    }

    public void setPamoCreateDate(Date pamoCreateDate) {
        this.pamoCreateDate = pamoCreateDate;
    }

    public Byte getPamoSort() {
        return pamoSort;
    }

    public void setPamoSort(Byte pamoSort) {
        this.pamoSort = pamoSort;
    }

    public Byte getPamoUseStatus() {
        return pamoUseStatus;
    }

    public void setPamoUseStatus(Byte pamoUseStatus) {
        this.pamoUseStatus = pamoUseStatus;
    }

	public ParentModule getPamoParentModule() {
		return pamoParentModule;
	}

	public void setPamoParentModule(ParentModule pamoParentModule) {
		this.pamoParentModule = pamoParentModule;
	}

	public List<Module> getPamoModules() {
		return pamoModules;
	}

	public void setPamoModules(List<Module> pamoModules) {
		this.pamoModules = pamoModules;
	}
}