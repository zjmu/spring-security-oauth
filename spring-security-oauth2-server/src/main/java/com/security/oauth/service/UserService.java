package com.security.oauth.service;

import com.security.oauth.domain.TbUser;

public interface UserService {

  TbUser getByUserName(String username);
}
