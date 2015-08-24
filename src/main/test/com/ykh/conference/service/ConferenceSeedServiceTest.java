package com.ykh.conference.service;

import com.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/8/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ConferenceSeedServiceTest {

    @Autowired ConferenceSeedService conferenceSeedService;
    @Test
    public void testGetConfTempId() throws Exception {
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(conferenceSeedService.getConfTempId(1, 1, "xx"));
    }
}