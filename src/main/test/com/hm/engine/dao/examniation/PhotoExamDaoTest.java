//package com.hm.engine.dao.examniation;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.engine.config.TestConfig;
//import com.hm.engine.dao.examniation.domain.PhotoExam;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestConfig.class })
//public class PhotoExamDaoTest {
//	@Autowired PhotoExamDao photoExamdao;
//	@Test
//	public void testSave() throws IOException {
//		List<String> list = Files.readAllLines(Paths.get("photoExam"),
//				Charset.defaultCharset());
//		for (String string : list) {
//			String[] sss= string.split("\\t");
//			PhotoExam i =new PhotoExam();
//			i.setId(Long.parseLong(sss[0]));
//			i.setExamName(sss[1]);
//			System.out.println(Arrays.toString(sss));
//			photoExamdao.save(i);
//		}
//	}
//
//}
