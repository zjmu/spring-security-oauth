package com.security.oauth.service;

import com.security.oauth.domain.Permission;

import java.util.List;

public interface PermissionService {

  List<Permission> selectByUserId(Long userId);
}
