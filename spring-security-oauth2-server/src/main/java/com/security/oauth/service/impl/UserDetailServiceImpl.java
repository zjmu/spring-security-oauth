package com.security.oauth.service.impl;

import com.security.oauth.domain.Permission;
import com.security.oauth.domain.TbUser;
import com.security.oauth.service.PermissionService;
import com.security.oauth.service.UserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**根据用户名找到用户id根据id找到用户权限，将二者放入用户信息
 * @author zhoujinmu
 * @title UserDetailServiceImpl
 * @projectName spring-security-oauth2
 * @description TODO
 * @created 2019-11-21 16:50
 **/
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Autowired
  private PermissionService permissionService;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    TbUser user = userService.getByUserName(username);
    List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
    if(user != null) {
      List<Permission> permissions = permissionService.selectByUserId(user.getId());
      permissions.forEach(permission -> {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
        grantedAuthorities.add(grantedAuthority);
      });
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
  }
}
