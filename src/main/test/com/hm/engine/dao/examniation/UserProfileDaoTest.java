package com.hm.engine.dao.examniation;

import com.engine.config.TestConfig;
import com.hm.engine.dao.examniation.domain.UserProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/7/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserProfileDaoTest {
    @Autowired UserProfileDao userProfileDao;
    @Test
    public  void save(){
        for (int i=0 ;i<100;i++)
        {    UserProfile userProfile =new UserProfile();
        userProfile.setUserGuid("7fb1a170-e378-4bfd-a10a-ed4550cc59e1"+i);
        userProfile.setBirthday(new Date());
        userProfile.setEthnicity("afdasd");
        userProfile.setUsername("maxiaochao");userProfile.setUserRealname("马晓超");
        userProfile.setEmail("xxxx@1123.com");
        userProfile.setMobile("1231231232");
        userProfileDao.save(userProfile);
    }
    }
}