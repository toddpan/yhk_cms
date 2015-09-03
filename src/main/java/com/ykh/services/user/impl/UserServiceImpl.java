///**
// * Project Name:vdi-core-server-lls
// * File Name:UserServiceImpl.java
// * Package Name:com.vdi.service.user.impl
// * Date:2014年8月8日上午11:17:23
// * Copyright (c) 2014 All Rights Reserved.
// *
// */
//
//package com.ykh.services.user.impl;
//
//import com.ykh.services.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.ykh.dao.user.UserDao;
//
//@Service
//public class UserServiceImpl implements UserService {
//	@Autowired UserDao userDao;
//	@Override
//	public UserDetails loadUserByUsername(String username)
//			throws UsernameNotFoundException {
//		return  userDao.findByUsername(username);
//	}
//
//
//
//
//}
