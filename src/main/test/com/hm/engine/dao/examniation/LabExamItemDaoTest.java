//package com.hm.engine.dao.examniation;
//
//import static org.junit.Assert.*;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.engine.config.TestConfig;
//
//import com.hm.engine.dao.examniation.domain.LabExamItem;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestConfig.class })
//public class LabExamItemDaoTest {
//@Autowired LabExamItemDao labExamItemDao;
//	@Test
//	public void testSave() throws IOException {
//		List<String> list = Files.readAllLines(Paths.get("labExamItem"),
//				Charset.defaultCharset());
//		for (String string : list) {
//			String[] sss = string.split("\\t");
//			LabExamItem labExamItem = new LabExamItem();
//			labExamItem.setExaminationItem(sss[0]);
//			labExamItem.setExaminationItemDecribe(sss[1]);
//			labExamItem.setSingleName(sss[2]);
//			labExamItemDao.save(labExamItem);
//		}
//
//
//	}
//
//}
