package com.hm.engine.facade.impl;

import com.engine.config.TestConfig;
import com.hm.engine.facade.UserProfileFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/7/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserProfileFacadeImplTest {
    @Autowired
    UserProfileFacade userProfileFacade;
    @Test
    public void test(){
        userProfileFacade.searchUserProfile(new PageRequest(0,1));
    }
}