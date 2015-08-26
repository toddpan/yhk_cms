package com.hm.engine.dao.examniation;

import com.engine.config.TestConfig;
import com.hm.engine.dao.examniation.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ant_shake_tree on 15/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class RiskDicDaoTest {
    @Autowired RiskDicDao riskDicDao;
    @Test
    public void saveRisk(){
        RiskDic riskDic = new RiskDic();
        riskDic.setRiskType(UserExams.class.getSimpleName());
        riskDic.setRiskTypeDesc("检查指标");
        riskDicDao.save(riskDic);



        RiskDic riskDic1 = new RiskDic();
        riskDic1.setRiskType(UserHabit.class.getSimpleName());
        riskDic1.setRiskTypeDesc("用户习惯");
        riskDicDao.save(riskDic1);



        RiskDic riskDic2 = new RiskDic();
        riskDic2.setRiskType(UserFamilyHealthHistory.class.getSimpleName());
        riskDic2.setRiskTypeDesc("家族史");
        riskDicDao.save(riskDic2);



        RiskDic riskDic3 = new RiskDic();
        riskDic3.setRiskType(UserDisease.class.getSimpleName());
        riskDic3.setRiskTypeDesc("疾病");
        riskDicDao.save(riskDic3);



    }
}
