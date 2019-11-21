package com.security.oauth.service.impl;

import com.security.oauth.domain.TbUser;
import com.security.oauth.mapper.UserDao;
import com.security.oauth.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author zhoujinmu
 * @title UserServiceImpl
 * @projectName spring-security-oauth2
 * @description TODO
 * @created 2019-11-21 15:38
 **/
@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserDao userDao;

  @Override
  public TbUser getByUserName(String username) {
    Example example = new Example(TbUser.class);
    example.createCriteria().andEqualTo("username",username);
    return userDao.selectOneByExample(example);
  }
}
