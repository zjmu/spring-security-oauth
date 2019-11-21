package com.security.oauth.service.impl;

import com.security.oauth.domain.Permission;
import com.security.oauth.mapper.PermissionDao;
import com.security.oauth.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoujinmu
 * @title PermissionServiceImpl
 * @projectName spring-security-oauth2
 * @description TODO
 * @created 2019-11-21 16:47
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

  @Resource
  private PermissionDao permissionDao;

  @Override
  public List<Permission> selectByUserId(Long userId) {
    return permissionDao.selectByUserId(userId);
  }
}
