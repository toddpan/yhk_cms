package com.ykh.dao.conference;

import com.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/8/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ConferenceSeedDaoTest {
    @Autowired ConferenceSeedDao conferenceSeedDao;

    @Test
    public void testFindMaxId() throws Exception {
        System.out.println(conferenceSeedDao.findMaxId());
    }
}