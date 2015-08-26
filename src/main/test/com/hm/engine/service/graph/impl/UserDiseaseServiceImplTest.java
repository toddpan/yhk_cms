package com.hm.engine.service.graph.impl;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.dao.examniation.domain.UserChiefComplaint;
import com.hm.engine.facade.ProcessFacade;
import com.hm.engine.service.graph.UserDiseaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserDiseaseServiceImplTest {
	@Autowired
	UserDiseaseService userDiseaseServices;
	@Autowired ProcessFacade processFacade;
	@Test
	public void testNextStep() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchFieldException, SecurityException {
		 userDiseaseServices.nextStep("xxx",1436180845146l);
	}

	@Test
	public void testPrincipleAction() {
		UserChiefComplaint disease = new UserChiefComplaint();
		disease.setDiseaseCode("E78");
		disease.setDiseaseType("principal");
		disease.setUserGuid("xxxx");
		// fail("Not yet implemented");
		userDiseaseServices.principleAction(disease);
	}

	
	
	
	@Test
	public void testSave(){
		userDiseaseServices.nextStep("1", 1436008995085L);
	}
}
