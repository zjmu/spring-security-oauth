package com.security.oauth2.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhoujinmu
 * @title PasswordWordEncoderTests
 * @projectName spring-security-oauth2
 * @description TODO
 * @created 2019-11-21 11:20
 **/
public class PasswordWordEncoderTests {

  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("secret"));
  }
}
