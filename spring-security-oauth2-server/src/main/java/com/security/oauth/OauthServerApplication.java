package com.security.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhoujinmu
 * @title OauthServerApplication
 * @projectName spring-security-oauth2
 * @description TODO
 * @created 2019-11-21 08:49
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.security.oauth.mapper")
public class OauthServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(OauthServerApplication.class,args);
  }
}
