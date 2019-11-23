package com.security.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zjm
 * @date 2019/11/22
 */
@SpringBootApplication
@EnableResourceServer
@EnableOAuth2Client
@MapperScan(basePackages = "com.security.oauth.mapper")
public class Oauth2ResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ResourceApplication.class, args);
    }
}
