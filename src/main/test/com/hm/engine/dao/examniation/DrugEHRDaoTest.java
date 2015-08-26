package com.hm.engine.dao.examniation;

import com.engine.config.TestConfig;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.hm.engine.dao.examniation.domain.DrugEHR;
import com.hm.engine.dao.examniation.domain.ExaminationItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ant_shake_tree on 15/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class DrugEHRDaoTest {
    @Autowired DrugEHRDao drugEHRDao;
    @Test
    public void convert(){
        List<DrugEHR> lists =drugEHRDao.findHql("from DrugEHR where comPyAll is null");
        for (DrugEHR l:lists){
            l.setCnPyAll(PinyinHelper.convertToPinyinString(l.getCnName(), "", PinyinFormat.WITHOUT_TONE));
            l.setCnPyHead(PinyinHelper.getShortPinyin(l.getCnName()));
            l.setComPyAll(PinyinHelper.convertToPinyinString(l.getCommonName(), "", PinyinFormat.WITHOUT_TONE));
            l.setComPyHead(PinyinHelper.getShortPinyin(l.getCommonName()));
            drugEHRDao.save(l);
        }
    }
}
