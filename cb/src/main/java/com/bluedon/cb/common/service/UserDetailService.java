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

import com.alibaba.fastjson.JSON;
import com.bluedon.cb.common.entity.RoleModule;
import com.bluedon.cb.common.entity.UserBasic;
import com.bluedon.cb.common.entity.UserRole;
import com.bluedon.cb.common.exmapper.ExUserBasicMapper;
import com.bluedon.cb.common.exmapper.ExUserRoleMapper;
import com.bluedon.cb.util.paging.PageContext;


/**
 * Description:
 * Time:2015年12月3日上午11:02:35
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Service
public class UserDetailService implements UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailService.class);
	
	@Resource
	private ExUserBasicMapper exUserBasicMapper;

	@Resource
	private ExUserRoleMapper exUserRoleMapper;
	
	@Resource
	private RoleModuleService roleModuleService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PageContext.getContext().setPagination(false);
        try{
			UserBasic userBasic = exUserBasicMapper.selectUserBasicByUserAccount(username);
	
			if(userBasic == null) {
				log.info("用户名为{}的用户不存在", username);
				return null;
			}
			
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("usbaId", userBasic.getUsbaId());
			List<UserRole> userRoles = exUserRoleMapper.selectUserRoleByUsbaId(map1);
			
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();	
			for(UserRole userRole: userRoles) {
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("roleId", userRole.getRoleId());
				List<RoleModule> roleModules = roleModuleService.getRoleModuleByRoleId(map2);
                System.out.print(JSON.toJSON(roleModules));
				for(RoleModule roleModule: roleModules) {
					authorities.add(new SimpleGrantedAuthority(roleModule.getExModuResource()));
				}
			}
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			userBasic.setUsbaGrantedAuthoritys(authorities);
			return userBasic;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
