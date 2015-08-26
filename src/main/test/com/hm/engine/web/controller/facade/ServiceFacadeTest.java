//package com.hm.engine.web.controller.facade;
//
//import static org.junit.Assert.fail;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.engine.config.TestConfig;
//import com.hm.engine.common.ParseJSON;
//import com.hm.engine.dao.examniation.domain.DiseaseExamMapping;
//import com.hm.engine.dao.examniation.domain.UserChiefComplaint;
//import com.hm.engine.facade.DoctorFacade;
//import com.hm.engine.facade.ProcessFacade;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestConfig.class })
//public class ServiceFacadeTest {
//
//	@Autowired DoctorFacade serviceFacade;
//	@Autowired ProcessFacade processFacade;
//
//	@Test
//	public void testSearchLabExamItem() {
//
//	}
//
//	@Test
//	public void testSearchLabExam() {
//		fail("Not yet implemented");
//	}
////
////	@Test
////	public void testSearchDisease() {
////		Disease disease =new Disease();
////		disease.setDiseaseCode("A");
////		ListDiseaseResponse re=		serviceFacade.searchDisease(disease);
////		for(Disease d :re.getBody()){
////			System.out.println("=================="+d.getDiseaseCode());
////		}
////
////	}
//
////	@Test
////	public void testSearchMedicineInquiry() {
////		MedicineInquiry medicineInquiry =new MedicineInquiry();
////		medicineInquiry.setExamName("xxx");
////		serviceFacade.searchMedicineInquiry(medicineInquiry );
////	}
//	@Test
//	public void searchUserProcess(){
//		UserChiefComplaint request=new UserChiefComplaint();
//		request.setDiseaseCode("E78");
//		request.setDiseaseSerialNumber(1435884995507l);
////		request.set
//		request.setUserGuid("xxxx");
//		System.out.println(ParseJSON.toJson(processFacade.searchUserProcess(request)));
//	}
//
//	@Test
//	public void pricipelAction(){
//		UserChiefComplaint request=new UserChiefComplaint();
//		request.setDiseaseCode("E78");
//		request.setUserGuid("xxxx");
//		System.out.println(processFacade.principleAction(request).getDiseaseSerialNumber());
//	}
//	@Test
//	public void searchDiseaseExamMapping(){
//		DiseaseExamMapping labExamItem=new DiseaseExamMapping();
//		labExamItem.setDiseaseCode("E78");
//		labExamItem.setUserGuid("xxxx");
//		serviceFacade.searchDiseaseExamMapping(labExamItem);
//	}
//}
