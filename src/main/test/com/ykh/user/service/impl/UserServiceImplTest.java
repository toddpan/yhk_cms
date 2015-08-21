package com.ykh.user.service.impl;
import com.config.TestConfig;
import com.ykh.conference.service.User;
import com.ykh.user.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @org.junit.Test
    public void testLoadUserByUsername() throws Exception {
        userService.loadUserByUsername("xx");
    }
}