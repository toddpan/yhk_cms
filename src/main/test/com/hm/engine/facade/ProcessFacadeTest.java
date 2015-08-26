//package com.hm.engine.facade;
//
//import static org.junit.Assert.fail;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.engine.config.TestConfig;
//import com.hm.engine.common.ParseJSON;
//import com.hm.engine.dao.examniation.domain.UserChiefComplaint;
//import com.hm.engine.dao.graph.domain.ProcessContent;
//import com.hm.engine.facade.pojo.ExamItems;
//import com.hm.engine.facade.request.GraphicProcessRequset;
//import com.hm.engine.facade.request.ListUserExams;
//import com.hm.engine.manager.type.enums.ExamType;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestConfig.class })
//public class ProcessFacadeTest {
//	@Autowired
//	ProcessFacade processFacade;
//
//	@Test
//	public void testPrincipleAction() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSearchUserProcess() {
//
//		UserChiefComplaint request=new UserChiefComplaint();
//		request.setDiseaseCode("E78");
//		request.setDiseaseSerialNumber(1436174521827l);
//		request.setUserGuid("1");
//		request.setDiseaseType("principal");
//		System.out.println(ParseJSON.toJson(processFacade.searchUserProcess(request)));
//	}
//
//	@Test
//	public void testSaveUserExams() {
////		 UserDisease request=new UserDisease();
//		ListUserExams request=new ListUserExams();
//		request.setDiseaseCode("E78");
//		request.setDiseaseType("principal");
//		request.setDiseaseSerialNumber(1436180845146l);
//		request.setUserGuid("xxx");
//		List<ExamItems> examItems=new ArrayList<ExamItems>();
//		ExamItems e=new ExamItems();
//		e.setExaminationItem("totalCholesterol");
//		e.setExaminationValue(5.8);
//		examItems.add(e);
//		ExamItems e2=new ExamItems();
//		e2.setExaminationItem("triglyceride");
//		e2.setExaminationValue(0.8);
//		examItems.add(e2);
//		request.setExamItems(examItems);
////		processFacade.saveUserExams(request);
////		 request.set
////		processFacade(request);
//	}
//
//	@Test
//	public void testSaveUserDoctorDecision() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSaveUserDisease() {
////		processFacade.
//	}
//	@Test
//	public void testS(){
////		processFacade.
//		GraphicProcessRequset request=new GraphicProcessRequset();
//		request.setDiseaseCode("E78");
//		request.setDiseaseType("principal");
//		ProcessContent head=new ProcessContent();
////		head.setEntity(ExamType.labExam.name());
//		head.setEntity(ExamType.physExam.name());
//		head.setId("10,11");
//		head.setNote("xxxxxx");
//		head.setType("indicatorDecision");
//		request.setHead(head);
//		ProcessContent tail=new ProcessContent();
//		tail.setType("indicatorDecision");
//		tail.setId("13,50");
//		tail.setEntity("labExam");
//		request.setTail(tail);
//		processFacade.mappingGraphicProcess(request);
//	}
//
//}
