package com.security.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author zhoujinmu
 * @title AuthorizationServerConfiguration
 * @projectName spring-security-oauth2
 * @description TODO
 * @created 2019-11-21 08:53
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public TokenStore tokenStore() {
    //token放入数据库
    return new JdbcTokenStore(dataSource());
  }

  public ClientDetailsService jdbcClientDetails() {
    return new JdbcClientDetailsService(dataSource());
  }
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//    clients.inMemory()
//      .withClient("client") //clientId
//      .secret(passwordEncoder.encode("secret")) //安全码
//      .authorizedGrantTypes("authorization_code") //简单模式、密码模式、简单模式、授权码模式
//      .scopes("app")
//      .redirectUris("http://www.funtl.com"); //回调地址，给授权码
    clients.withClientDetails(jdbcClientDetails());
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore());
  }
}
