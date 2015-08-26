package com.hm.engine.service.graph.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.service.graph.ParseProcessService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ParseProcessServiceImplTest {
@Autowired ParseProcessService parseProcessService;
	@Test
	public void testParseProcess() {
		parseProcessService.parseProcess("dtdtojava.xml");
	}

}
