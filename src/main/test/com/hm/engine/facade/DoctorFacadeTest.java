package com.hm.engine.facade;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.hm.engine.dao.examniation.domain.*;
import com.hm.engine.facade.request.UserDiseaseRequest;
import com.hm.engine.manager.enums.ExamType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.google.common.collect.Lists;
import com.hm.engine.common.ParseJSON;
import com.hm.engine.facade.pojo.ExamItems;
import com.hm.engine.facade.request.ListExaminationReport;
import com.hm.engine.facade.request.ListUserExams;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class DoctorFacadeTest {
	@Autowired DoctorFacade doctorFacade;
	@Test
	public void testSearchDiseaseExamMapping() {
		DiseaseExamMapping labExamItem=new DiseaseExamMapping();
		labExamItem.setDiseaseCode("E14.901");
//		labExamItem.setExamType(ExamType.labExam);
//	System.out.println();
		List<ExamMappingView> v =doctorFacade.recomExamItemsByDiseases(labExamItem).getBody();

		for (ExamMappingView examMappingView : v) {
			System.out.println(ParseJSON.toJson(examMappingView));
		}
	}@Test
	public void testRecomDiseaseByUserExams() {
		ListUserExams listUserExams =new ListUserExams();
		listUserExams.setUserGuid("H01368782");
		listUserExams.setDiseaseSerialNumber(1694884817l);
		System.out.println(ParseJSON.toJson(doctorFacade.recomDiseaseByUserExams(listUserExams)));

	}@Test
	public void decisionMedicationPrescription() {
		UserChiefComplaint userChiefComplaint =new UserChiefComplaint();
		userChiefComplaint.setDiseaseCode("E78.001");
		userChiefComplaint.setUserGuid("xxxx");
		System.out.println(ParseJSON.toJson(doctorFacade.decisionMedicationPrescription(userChiefComplaint)));

	}

	@Test
	public void decisionMedicationPrescriptionDis() {
		UserDisease userDisease = new UserDisease();

		userDisease.setDiseaseSerialNumber(123l);
		userDisease.setUserGuid("xxxx");
		System.out.println(ParseJSON.toJson(doctorFacade.recomMedicationPrescriptionByUserGuidAndDiseaseSerialNumber(userDisease)));

	}
	@Test
	public void saveMedicationProscription(){
		UserDiseaseRequest disease = new UserDiseaseRequest();
		disease.setUserGuid("xxxx");
		disease.setDiseaseSerialNumber(123l);

		List<UserDisease> userDiseases =Lists.newLinkedList();
		UserDisease userDisease = new UserDisease();
		userDisease.setDiseaseCode("E78.001");
		userDiseases.add(userDisease);
		disease.setUserDiseases(userDiseases);
		doctorFacade.saveUserDisease(disease);
	}
}
