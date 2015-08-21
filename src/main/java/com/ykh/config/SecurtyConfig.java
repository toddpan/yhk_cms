package com.ykh.config;//package com.ykh.config;
///**
// * Project Name:vdi-core-server-lls
// * File Name:SecurtyConfig.java
// * Package Name:com.vdi.config
// * Date:2014年8月8日下午6:23:23
// * Copyright (c) 2014 All Rights Reserved.
// *
// */
//
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//
//@Configuration
//@EnableWebMvcSecurity
//@Order(2)
//public class SecurtyConfig extends WebSecurityConfigurerAdapter {
//	@Resource(name="ticketAuthenticationProvider")
//	private AuthenticationProvider authenticationProvider;
//
//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder authManagerBuilder)
//			throws Exception {
//		authManagerBuilder.authenticationProvider(new AuthenticationProvider() {
//			
//			@Override
//			public boolean supports(Class<?> authentication) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//			
//			@Override
//			public Authentication authenticate(Authentication authentication)
//					throws AuthenticationException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
//
//	}
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//    }    
//}
