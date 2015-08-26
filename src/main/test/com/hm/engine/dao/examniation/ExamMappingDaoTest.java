package com.hm.engine.dao.examniation;

import com.engine.config.TestConfig;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.hm.engine.dao.examniation.domain.ExamMapping;
import com.hm.engine.dao.examniation.domain.ExaminationList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/7/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ExamMappingDaoTest {
    @Autowired
    ExamMappingDao examMappingDao;
//    @Test
//    public void list() {
//        List<ExamMapping> lists =examMappingDao.findAll();
//        for (ExaminationList l:lists){
//
//            l.setQueryIndexPYAll(PinyinHelper.convertToPinyinString(l.get(), "", PinyinFormat.WITHOUT_TONE));
//            l.setQueryIndexPYSimple(PinyinHelper.getShortPinyin(l.getExamName()));
//            examMappingDao.save(l);
//        }
//    }
}