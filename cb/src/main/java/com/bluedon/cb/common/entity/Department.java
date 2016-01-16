/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:部门
 * Time:2015年12月2日上午11:33:41
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class Department implements Serializable{
    private static final long serialVersionUID = -6975624993026668577L;

	private Integer depaId;

    private Integer depDepaId;

    private String depaName;

    private String depaDescription;

    private Date depaModifyDate;

    private Date depaCreateDate;

    private String depaNo;

    private Integer gradId;

    public Integer getDepaId() {
        return depaId;
    }

    public void setDepaId(Integer depaId) {
        this.depaId = depaId;
    }

    public Integer getDepDepaId() {
        return depDepaId;
    }

    public void setDepDepaId(Integer depDepaId) {
        this.depDepaId = depDepaId;
    }

    public String getDepaName() {
        return depaName;
    }

    public void setDepaName(String depaName) {
        this.depaName = depaName;
    }

    public String getDepaDescription() {
        return depaDescription;
    }

    public void setDepaDescription(String depaDescription) {
        this.depaDescription = depaDescription;
    }

    public Date getDepaModifyDate() {
        return depaModifyDate;
    }

    public void setDepaModifyDate(Date depaModifyDate) {
        this.depaModifyDate = depaModifyDate;
    }

    public Date getDepaCreateDate() {
        return depaCreateDate;
    }

    public void setDepaCreateDate(Date depaCreateDate) {
        this.depaCreateDate = depaCreateDate;
    }

    public String getDepaNo() {
        return depaNo;
    }

    public void setDepaNo(String depaNo) {
        this.depaNo = depaNo;
    }

    public Integer getGradId() {
        return gradId;
    }

    public void setGradId(Integer gradId) {
        this.gradId = gradId;
    }
}