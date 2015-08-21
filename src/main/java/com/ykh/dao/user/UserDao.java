package com.ykh.dao.user;


import com.ykh.dao.Dao;
import com.ykh.dao.user.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserDao extends Dao<User,Integer>{

    User findByUsername(String username);
}
