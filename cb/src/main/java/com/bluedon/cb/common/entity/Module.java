/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:模块
 * Time:2015年12月2日上午11:34:09
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class Module implements Serializable{
    private static final long serialVersionUID = -6028758876196823651L;

	private Integer moduId;

    private Integer pamoId;

    private String moduName;

    private String moduDescribe;

    private String moduUrl;

    private String moduIcon;

    private String moduResource;

    private Date moduModifyDate;

    private Date moduCreateDate;

    private Byte moduSort;

    private Byte moduUseStatus;

    public Integer getModuId() {
        return moduId;
    }

    public void setModuId(Integer moduId) {
        this.moduId = moduId;
    }

    public Integer getPamoId() {
        return pamoId;
    }

    public void setPamoId(Integer pamoId) {
        this.pamoId = pamoId;
    }

    public String getModuName() {
        return moduName;
    }

    public void setModuName(String moduName) {
        this.moduName = moduName;
    }

    public String getModuDescribe() {
        return moduDescribe;
    }

    public void setModuDescribe(String moduDescribe) {
        this.moduDescribe = moduDescribe;
    }

    public String getModuUrl() {
        return moduUrl;
    }

    public void setModuUrl(String moduUrl) {
        this.moduUrl = moduUrl;
    }

    public String getModuIcon() {
        return moduIcon;
    }

    public void setModuIcon(String moduIcon) {
        this.moduIcon = moduIcon;
    }

    public String getModuResource() {
        return moduResource;
    }

    public void setModuResource(String moduResource) {
        this.moduResource = moduResource;
    }

    public Date getModuModifyDate() {
        return moduModifyDate;
    }

    public void setModuModifyDate(Date moduModifyDate) {
        this.moduModifyDate = moduModifyDate;
    }

    public Date getModuCreateDate() {
        return moduCreateDate;
    }

    public void setModuCreateDate(Date moduCreateDate) {
        this.moduCreateDate = moduCreateDate;
    }

    public Byte getModuSort() {
        return moduSort;
    }

    public void setModuSort(Byte moduSort) {
        this.moduSort = moduSort;
    }

    public Byte getModuUseStatus() {
        return moduUseStatus;
    }

    public void setModuUseStatus(Byte moduUseStatus) {
        this.moduUseStatus = moduUseStatus;
    }
}