package com.security.oauth.mapper;


import com.security.oauth.domain.Permission;
import mapperInter.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao extends MyMapper<Permission> {

  List<Permission> selectByUserId(@Param("userId")Long userId);

}
