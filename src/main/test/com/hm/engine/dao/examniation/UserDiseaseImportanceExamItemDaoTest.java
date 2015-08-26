package com.hm.engine.dao.examniation;

import com.engine.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserDiseaseImportanceExamItemDaoTest {
@Autowired UserDiseaseImportanceExamItemDao userDiseaseImportanceExamItemDao;
    @Test
    public void testFindByUserGuid() throws Exception {
        userDiseaseImportanceExamItemDao.findByUserGuid("xxx");
    }
}