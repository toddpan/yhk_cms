package com.hm.engine.config.bean;

import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.service.graph.UserDiseaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class DynamicBeanManagerTest {
	@Autowired
	DynamicBeanManager dynamicBeanManager;
	@Autowired UserDiseaseService d;
	@Test
	public void testGetContent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException {
		// fail("Not yet implemented");
		UserDiseaseService digraphService = (UserDiseaseService) dynamicBeanManager.getBean("digraphService", UserDiseaseService.class);
//		digraphService.nextStep("xxx");
		System.out.println(digraphService);
		System.out.println(d);
	}

}
