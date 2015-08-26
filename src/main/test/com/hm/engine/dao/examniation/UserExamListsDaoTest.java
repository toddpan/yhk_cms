package com.hm.engine.dao.examniation;

import com.engine.config.TestConfig;
import com.hm.engine.dao.examniation.domain.ExaminationList;
import com.hm.engine.dao.examniation.domain.UserExamLists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ant_shake_tree on 15/7/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserExamListsDaoTest {


    private @Autowired UserExamListsDao userExamListsDao;

    private @Autowired
    ExaminationListDao examinationListDao;


    @Test
    public void save(){
        List<ExaminationList> el = examinationListDao.findAll();

        for (ExaminationList list:el){
            UserExamLists userExamLists = new UserExamLists();
            userExamLists.setDiseaseSerialNumber(System.currentTimeMillis());
            userExamLists.setExamType(list.getExamType());
            userExamLists.setExamListId(list.getExamListId());
            userExamLists.setComment("balablabakdjflasjdfkjasfjasjdkfjal");
            userExamLists.setFinalDate(new Date());
            userExamLists.setOpenDate(new Date());
            userExamLists.setUserGuid("7fb1a170-e378-4bfd-a10a-ed4550cc59e1");
            userExamLists.setDoctorGuid("7fb1a170-e378-4bfd-a10a-ed4550cc59e1");
            userExamListsDao.save(userExamLists);

        }
    }
    @Test
    public void find(){
//        List<UserExamLists> userExamLists=   userExamListsDao.findHql("from UserExamLists where userGuid=?","xxxx");

        List<UserExamLists> userExamLists=   userExamListsDao.findHql("select new UserExamLists(reason,diseaseSerialNumber,userGuid,examType,examListId,openDate,max(finalDate),doctorGuid,comment) from UserExamLists where userGuid=? group by userGuid,examType,examListId","7fb1a170-e378-4bfd-a10a-ed4550cc59e1");
    for (UserExamLists sl:userExamLists){
        System.out.println(sl.getComment());
        System.out.println(sl.getFinalDate());
    }


    }


}