//package com.hm.engine.dao.examniation;
//
//import static org.junit.Assert.*;
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
//import com.hm.engine.dao.examniation.domain.MedicineInquiryMapping;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestConfig.class })
//public class MedicineInquiryMappingMappingTest {
//	@Autowired MedicineInquiryMappingDao medicineInquiryMappingDao;
//	@Test
//	public void testSave() throws IOException {
//		List<String> list = Files.readAllLines(Paths.get("medicineInquiryMapping"),
//				Charset.defaultCharset());
//		for (String string : list) {
//			String[] strs = string.split("\\t");
//
//			MedicineInquiryMapping inquiryMapping =new MedicineInquiryMapping();
//			inquiryMapping.setExamListId(Long.parseLong(strs[0]));
//			inquiryMapping.setExaminationItem(strs[2]);
//			medicineInquiryMappingDao.save(inquiryMapping);
//		}
//
//	}
//
//}
