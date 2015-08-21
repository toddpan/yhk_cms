package com.ykh.facade.impl;

import com.config.TestConfig;
import com.google.common.collect.Lists;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.tang.agent.vo.AutoStopParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ConferenceFacadeImplTest {
    @Autowired
    ConferenceFacadeImpl conferenceFacade;
    @Test
    public void test(){
        Conference conference =new Conference();
        AutoStopParams autoStopParams =new AutoStopParams();
        List<String> role = Lists.newArrayList();
        role.add("Auto");
        autoStopParams.setRoles(role);

        conference.setAutoStopParams(autoStopParams);
        conference.setBillingcode(1231239);
        conference.setConferencename("xxxx");
        conference.setPassword("xxxx");
        conference.setConfScale(1);
        conferenceFacade.openConference(conference);
    }
}