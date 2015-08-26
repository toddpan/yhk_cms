package com.hm.engine.dao.graph.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.dao.graph.ExpressionDao;
import com.hm.engine.dao.graph.domain.Expression;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ExpressionDaoImplTest {
@Autowired ExpressionDao expressionDao;
	@Test
	public void testSave() throws IOException {
//		List<String> list = Files.readAllLines(
//				Paths.get("testRules"), Charset.defaultCharset());
//		for (String string : list) {
//			Expression content =new Expression();
//			String[] strs =string.split("\\t");
		Expression content =new Expression();

			content.setExpression("xxx");
			content.setExpressionId(1000l);
//			content.setDiseaseCode("E78");
			expressionDao.save(content);
		}
	}

