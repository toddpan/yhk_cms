package com.hm.engine.dao.examniation;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.dao.examniation.domain.ExamMappingView;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ExamMappingViewDaoTest {
@Autowired ExamMappingViewDao examMappingViewDao;
	@Test
	public void testFindAll() {
		ExamMappingView view=new ExamMappingView();
		view.setDiseaseCode("E");
		List<ExamMappingView> li= examMappingViewDao.findAll(view);
		for (ExamMappingView examMappingView : li) {
			System.out.println(examMappingView.getExaminationItem());
		}
		
	}

}
