//package com.hm.engine.dao.examniation;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.engine.config.TestConfig;
//import com.hm.engine.dao.examniation.domain.MedicineInquiry;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestConfig.class })
//public class MedicineInquiryDaoTest {
//@Autowired MedicineInquiryDao medicineInquiryDao;
//	@Test
//	public void testSave() throws IOException {
//		List<String> list = Files.readAllLines(Paths.get("medicineInquiry"),
//				Charset.defaultCharset());
//		MedicineInquiry medicineInquiry =new MedicineInquiry();
//		for (String string : list) {
//			String[] strs = string.split("\\t");
//
//			medicineInquiry.setId(Long.parseLong(strs[0]));
//			medicineInquiry.setExamName(strs[1]);
//			medicineInquiryDao.save(medicineInquiry);
//		}
//
//	}
//
//}
