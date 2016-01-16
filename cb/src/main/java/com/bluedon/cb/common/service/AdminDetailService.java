package com.bluedon.cb.common.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bluedon.cb.common.entity.AdminRole;
import com.bluedon.cb.common.entity.Administrator;
import com.bluedon.cb.common.entity.RoleModule;
import com.bluedon.cb.common.exmapper.ExAdminRoleMapper;
import com.bluedon.cb.common.exmapper.ExAdministratorMapper;
import com.bluedon.cb.util.paging.PageContext;

/**
 * Description		: 
 * 
 * <br><br>Time		: 2015-11-14  上午10:08:57
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author chenchengteng
 */
@Service
public class AdminDetailService implements UserDetailsService{
	
	private static final Logger log = LoggerFactory.getLogger(AdminDetailService.class);
	
	@Resource
	private ExAdministratorMapper exAdministratorMapper;
	
	@Resource
	private ExAdminRoleMapper exAdminRoleMapper;

	@Resource
	private RoleModuleService roleModuleService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PageContext.getContext().setPagination(false);
        try{
		Administrator administrator = exAdministratorMapper.selectAdministratorByUsername(username);				
		
		if(administrator == null) {
			log.info("用户名为{}的用户不存在", username);
			return null;
		}
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("admiId", administrator.getAdmiId());
		List<AdminRole> adminRoles = exAdminRoleMapper.selectAdminRoleByAdmiId(map1);	
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(AdminRole adminRole: adminRoles) {
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("roleId", adminRole.getRoleId());
			List<RoleModule> roleModules = roleModuleService.getRoleModuleByRoleId(map2);
			for(RoleModule roleModule: roleModules) {
				authorities.add(new SimpleGrantedAuthority(roleModule.getExModuResource()));
			}
		}
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		administrator.setAdmiAuthorities(authorities);
		return administrator;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
