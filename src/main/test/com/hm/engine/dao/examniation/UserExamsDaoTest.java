package com.hm.engine.dao.examniation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.dao.examniation.domain.UserExams;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserExamsDaoTest {
	@Autowired UserExamsDao userExamsDao;
	@Test
	public void test() {
		UserExams e2=new UserExams();
		e2.setUserGuid("xxx");
		e2.setExaminationItem("totalCholesterol");
//		e2.setExaminationValue(0.8);
		e2.setDiseaseSerialNumber(1436180845146l);
//		e2.setSortkey("examinationTime");
//		e2.setAscend(0);
		UserExams dao=	userExamsDao.findOne(e2);
		System.out.println(dao);
	}

}
