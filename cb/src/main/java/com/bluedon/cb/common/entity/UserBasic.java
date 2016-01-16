/**
 * Copyright (c) 2015
 * Company:蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.common.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Description:用户基本信息
 * Time:2015年12月4日下午3:01:33
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
public class UserBasic implements UserDetails{
    private static final long serialVersionUID = 1192225032332697068L;

	private Integer usbaId;

    private Integer depaId;

    private String usbaAccount;

    private String usbaName;

    private String usbaPassword;

    private Byte usbaFailureCount;

    private Byte usbaCredentialExpired;

    private Byte usbaAccountExpired;

    private Byte usbaAccountEnable;

    private Byte usbaAccountLocked;

    private Date usbaModifyDate;

    private Date usbaCreateDate;
    
    /** 用户的角色列表. */
    private List<UserRole> usbaUserRoles;
    
    /** 权限列表，security使用. */
	private List<GrantedAuthority> usbaGrantedAuthoritys;

    public Integer getUsbaId() {
        return usbaId;
    }

    public void setUsbaId(Integer usbaId) {
        this.usbaId = usbaId;
    }

    public Integer getDepaId() {
        return depaId;
    }

    public void setDepaId(Integer depaId) {
        this.depaId = depaId;
    }

    public String getUsbaAccount() {
        return usbaAccount;
    }

    public void setUsbaAccount(String usbaAccount) {
        this.usbaAccount = usbaAccount;
    }

    public String getUsbaName() {
        return usbaName;
    }

    public void setUsbaName(String usbaName) {
        this.usbaName = usbaName;
    }

    public String getUsbaPassword() {
        return usbaPassword;
    }

    public void setUsbaPassword(String usbaPassword) {
        this.usbaPassword = usbaPassword;
    }

    public Byte getUsbaFailureCount() {
        return usbaFailureCount;
    }

    public void setUsbaFailureCount(Byte usbaFailureCount) {
        this.usbaFailureCount = usbaFailureCount;
    }

    public Byte getUsbaCredentialExpired() {
        return usbaCredentialExpired;
    }

    public void setUsbaCredentialExpired(Byte usbaCredentialExpired) {
        this.usbaCredentialExpired = usbaCredentialExpired;
    }

    public Byte getUsbaAccountExpired() {
        return usbaAccountExpired;
    }

    public void setUsbaAccountExpired(Byte usbaAccountExpired) {
        this.usbaAccountExpired = usbaAccountExpired;
    }

    public Byte getUsbaAccountEnable() {
        return usbaAccountEnable;
    }

    public void setUsbaAccountEnable(Byte usbaAccountEnable) {
        this.usbaAccountEnable = usbaAccountEnable;
    }

    public Byte getUsbaAccountLocked() {
        return usbaAccountLocked;
    }

    public void setUsbaAccountLocked(Byte usbaAccountLocked) {
        this.usbaAccountLocked = usbaAccountLocked;
    }

    public Date getUsbaModifyDate() {
        return usbaModifyDate;
    }

    public void setUsbaModifyDate(Date usbaModifyDate) {
        this.usbaModifyDate = usbaModifyDate;
    }

    public Date getUsbaCreateDate() {
        return usbaCreateDate;
    }

    public void setUsbaCreateDate(Date usbaCreateDate) {
        this.usbaCreateDate = usbaCreateDate;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return usbaPassword;
	}

	@Override
	public String getUsername() {
		return usbaAccount;
	}

	@Override
	public boolean isAccountNonExpired() {
		if(usbaAccountExpired != null){
			if (usbaAccountExpired == 1){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(usbaAccountLocked != null){
			if (usbaAccountLocked == 1){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if(usbaCredentialExpired != null){
			if (usbaCredentialExpired == 1){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEnabled() {
		if(usbaAccountEnable != null){
			if (usbaAccountEnable == 1){
				return true;
			}
		}
		return false;
	}

	public List<UserRole> getUsbaUserRoles() {
		return usbaUserRoles;
	}

	public void setUsbaUserRoles(List<UserRole> usbaUserRoles) {
		this.usbaUserRoles = usbaUserRoles;
	}

	public List<GrantedAuthority> getUsbaGrantedAuthoritys() {
		return usbaGrantedAuthoritys;
	}

	public void setUsbaGrantedAuthoritys(List<GrantedAuthority> usbaGrantedAuthoritys) {
		this.usbaGrantedAuthoritys = usbaGrantedAuthoritys;
	}
}