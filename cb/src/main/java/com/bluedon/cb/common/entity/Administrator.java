/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Description:管理员
 * Time:2015年12月2日上午11:32:44
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class Administrator implements UserDetails , Serializable{
    private static final long serialVersionUID = 8133209748726169147L;

	private Integer admiId;

    private String admiAccount;

    private String admiName;

    private String admiPassword;

    private String admiMail;

    private String admiFailureCount;

    private Byte admiCredentialExpired;

    private Byte admiAccountExpired;

    private Byte admiAccountEnable;

    private Byte admiAccountLocked;

    private Date admiModifyDate;

    private Date admiCreateDate;

    public Integer getAdmiId() {
        return admiId;
    }

    public void setAdmiId(Integer admiId) {
        this.admiId = admiId;
    }

    public String getAdmiAccount() {
        return admiAccount;
    }

    public void setAdmiAccount(String admiAccount) {
        this.admiAccount = admiAccount;
    }

    public String getAdmiName() {
        return admiName;
    }

    public void setAdmiName(String admiName) {
        this.admiName = admiName;
    }

    public String getAdmiPassword() {
        return admiPassword;
    }

    public void setAdmiPassword(String admiPassword) {
        this.admiPassword = admiPassword;
    }

    public String getAdmiMail() {
        return admiMail;
    }

    public void setAdmiMail(String admiMail) {
        this.admiMail = admiMail;
    }

    public String getAdmiFailureCount() {
        return admiFailureCount;
    }

    public void setAdmiFailureCount(String admiFailureCount) {
        this.admiFailureCount = admiFailureCount;
    }

    public Byte getAdmiCredentialExpired() {
        return admiCredentialExpired;
    }

    public void setAdmiCredentialExpired(Byte admiCredentialExpired) {
        this.admiCredentialExpired = admiCredentialExpired;
    }

    public Byte getAdmiAccountExpired() {
        return admiAccountExpired;
    }

    public void setAdmiAccountExpired(Byte admiAccountExpired) {
        this.admiAccountExpired = admiAccountExpired;
    }

    public Byte getAdmiAccountEnable() {
        return admiAccountEnable;
    }

    public void setAdmiAccountEnable(Byte admiAccountEnable) {
        this.admiAccountEnable = admiAccountEnable;
    }

    public Byte getAdmiAccountLocked() {
        return admiAccountLocked;
    }

    public void setAdmiAccountLocked(Byte admiAccountLocked) {
        this.admiAccountLocked = admiAccountLocked;
    }

    public Date getAdmiModifyDate() {
        return admiModifyDate;
    }

    public void setAdmiModifyDate(Date admiModifyDate) {
        this.admiModifyDate = admiModifyDate;
    }

    public Date getAdmiCreateDate() {
        return admiCreateDate;
    }

    public void setAdmiCreateDate(Date admiCreateDate) {
        this.admiCreateDate = admiCreateDate;
    }


	/** 权限列表，security使用 */
	private List<GrantedAuthority> admiAuthorities;
	
	public void setAdmiAuthorities(List<GrantedAuthority> admiAuthorities){
		this.admiAuthorities = admiAuthorities;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return admiAuthorities;
	}

	public String getPassword() {
		return admiPassword;
	}

	public String getUsername() {
		return admiName;
	}

	public boolean isAccountNonExpired() {
		if(admiAccountExpired != null){
			if (admiAccountExpired == 1){
				return true;
			}
		}
		return false;
	}

	public boolean isAccountNonLocked() {
		if(admiAccountLocked != null){
			if (admiAccountLocked == 1){
				return true;
			}
		}
		return false;
	}

	public boolean isCredentialsNonExpired() {
		if(admiCredentialExpired != null){
			if (admiCredentialExpired == 1){
				return true;
			}
		}
		return false;
	}

	public boolean isEnabled() {
		if(admiAccountEnable != null){
			if (admiAccountEnable == 1){
				return true;
			}
		}
		return false;
	}
}