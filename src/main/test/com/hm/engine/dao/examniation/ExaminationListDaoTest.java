package com.hm.engine.dao.examniation;

import com.engine.config.TestConfig;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.google.common.collect.Lists;
import com.hm.engine.common.BeanUtils;
import com.hm.engine.dao.examniation.domain.*;
import com.hm.engine.manager.enums.ExamType;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/7/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ExaminationListDaoTest {
    @Autowired
    ExaminationListDao examinationListDao;


    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void list() {
        List<ExaminationList> lists =examinationListDao.findAll();
        for (ExaminationList l:lists){

            l.setQueryIndexPYAll(PinyinHelper.convertToPinyinString(l.getExamName(), "", PinyinFormat.WITHOUT_TONE));
            l.setQueryIndexPYSimple(PinyinHelper.getShortPinyin(l.getExamName()));
            examinationListDao.save(l);
        }
    }
}