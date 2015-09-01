package com.ykh.services.conference;

import com.config.TestConfig;
import com.ykh.dao.conference.domain.Conference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ant_shake_tree on 15/8/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ConferenceSeedServiceTest {

    @Autowired ConferenceSeedService conferenceSeedService;
//    @Autowired ConferenceService conferenceService;
    @Test
    public void testGetConfTempId() throws Exception {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(conferenceSeedService.getConfTempId(1, 1, "xx"));
        Conference c =new Conference();
//        conferenceService.createConference(c);

    }
}