package com.bluedon.cb.common.entity;

import java.util.Date;

public class SystemLog {
    private Integer syloId;

    private String syloMethod;

    private String syloDescription;

    private Byte syloType;

    private String syloIp;

    private String syloExceptionCode;

    private String syloExceptionDetail;

    private String syloParams;

    private Integer syloUsroId;

    private String syloUsroName;

    private String syloRoleName;

    private Date syloCreateDate;

    private String syloSql;

    public Integer getSyloId() {
        return syloId;
    }

    public void setSyloId(Integer syloId) {
        this.syloId = syloId;
    }

    public String getSyloMethod() {
        return syloMethod;
    }

    public void setSyloMethod(String syloMethod) {
        this.syloMethod = syloMethod;
    }

    public String getSyloDescription() {
        return syloDescription;
    }

    public void setSyloDescription(String syloDescription) {
        this.syloDescription = syloDescription;
    }

    public Byte getSyloType() {
        return syloType;
    }

    public void setSyloType(Byte syloType) {
        this.syloType = syloType;
    }

    public String getSyloIp() {
        return syloIp;
    }

    public void setSyloIp(String syloIp) {
        this.syloIp = syloIp;
    }

    public String getSyloExceptionCode() {
        return syloExceptionCode;
    }

    public void setSyloExceptionCode(String syloExceptionCode) {
        this.syloExceptionCode = syloExceptionCode;
    }

    public String getSyloExceptionDetail() {
        return syloExceptionDetail;
    }

    public void setSyloExceptionDetail(String syloExceptionDetail) {
        this.syloExceptionDetail = syloExceptionDetail;
    }

    public String getSyloParams() {
        return syloParams;
    }

    public void setSyloParams(String syloParams) {
        this.syloParams = syloParams;
    }

    public Integer getSyloUsroId() {
        return syloUsroId;
    }

    public void setSyloUsroId(Integer syloUsroId) {
        this.syloUsroId = syloUsroId;
    }

    public String getSyloUsroName() {
        return syloUsroName;
    }

    public void setSyloUsroName(String syloUsroName) {
        this.syloUsroName = syloUsroName;
    }

    public String getSyloRoleName() {
        return syloRoleName;
    }

    public void setSyloRoleName(String syloRoleName) {
        this.syloRoleName = syloRoleName;
    }

    public Date getSyloCreateDate() {
        return syloCreateDate;
    }

    public void setSyloCreateDate(Date syloCreateDate) {
        this.syloCreateDate = syloCreateDate;
    }

    public String getSyloSql() {
        return syloSql;
    }

    public void setSyloSql(String syloSql) {
        this.syloSql = syloSql;
    }
}