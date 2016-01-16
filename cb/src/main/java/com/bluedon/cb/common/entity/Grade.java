/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.io.Serializable;

/**
 * Description:级别（部门级别）
 * Time:2015年12月2日上午11:33:48
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class Grade implements Serializable{
    private static final long serialVersionUID = -3954503625117373504L;

	private Integer gradId;

    private Integer gradGradeNo;

    private String gradGradeName;

    public Integer getGradId() {
        return gradId;
    }

    public void setGradId(Integer gradId) {
        this.gradId = gradId;
    }

    public Integer getGradGradeNo() {
        return gradGradeNo;
    }

    public void setGradGradeNo(Integer gradGradeNo) {
        this.gradGradeNo = gradGradeNo;
    }

    public String getGradGradeName() {
        return gradGradeName;
    }

    public void setGradGradeName(String gradGradeName) {
        this.gradGradeName = gradGradeName;
    }
}