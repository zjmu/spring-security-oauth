package com.security.oauth.config;

import com.security.oauth.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhoujinmu
 * @title WebSecurityConfiguration
 * @projectName spring-security-oauth2
 * @description TODO
 * @created 2019-11-21 09:13
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


   /**
     * @author zjm
     * @date 2019/11/22
     * @description 数据库取用户详情
     */
   @Bean
   @Override
  public UserDetailsService userDetailsService() {
    return new UserDetailServiceImpl();
  }

   /**
     * @author zjm
     * @date 2019/11/22
     * @description 配置加密器
     */
   @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

   /**
     * @author zjm
     * @date 2019/11/22
     * @description 通过用户详情认证
     */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());

  }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/oauth/check_token");
    }
}
