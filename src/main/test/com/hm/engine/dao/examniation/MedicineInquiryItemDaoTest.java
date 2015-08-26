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
//import com.hm.engine.dao.examniation.domain.MedicineInquiryItem;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestConfig.class })
//public class MedicineInquiryItemDaoTest {
//	@Autowired MedicineInquiryItemDao medicineInquiryItemDao;
//	@Test
//	public void testSave() throws IOException {
//		List<String> list = Files.readAllLines(Paths.get("medicineInquiryItem"),
//				Charset.defaultCharset());
//		for (String string : list) {
//			String[] strs = string.split("\\t");
//
//			MedicineInquiryItem inquiryItem =new MedicineInquiryItem();
//			inquiryItem.setExaminationItem(strs[0]);
//			inquiryItem.setExaminationItemDecribe(strs[1]);
//			medicineInquiryItemDao.save(inquiryItem);
//		}
//
//	}
//
//}
