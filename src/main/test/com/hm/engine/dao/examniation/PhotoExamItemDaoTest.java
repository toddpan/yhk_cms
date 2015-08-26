//package com.hm.engine.dao.examniation;
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
//import com.hm.engine.dao.examniation.domain.PhotoExamItem;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestConfig.class })
//public class PhotoExamItemDaoTest {
//	@Autowired
//	PhotoExamItemDao photoExamItemDao;
//
//	@Test
//	public void testSave() throws IOException {
//		List<String> list = Files.readAllLines(Paths.get("photoExamItem"),
//				Charset.defaultCharset());
//		for (String string : list) {
//			String[] sss = string.split("\\t");
//
//			PhotoExamItem labExamItem = new PhotoExamItem();
//			labExamItem.setExaminationItem(sss[0]);
//			labExamItem.setExaminationItemDecribe(sss[1]);
//			if (sss.length > 1) {
//				labExamItem.setSingleName(sss[2]);
//			}
//			if (sss.length > 2) {
//				try {
//					labExamItem.setExaminationPurpose(sss[3]);
//					labExamItem.setExaminationResult(sss[4]);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			photoExamItemDao.save(labExamItem);
//		}
//	}
//
//}
