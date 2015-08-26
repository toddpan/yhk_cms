package com.hm.engine.service.graph.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.hm.engine.common.ConfigUtil;
import com.hm.engine.common.ParseJSON;
import com.hm.engine.dao.examniation.domain.*;
import com.hm.engine.facade.pojo.ExamItems;
import com.hm.engine.facade.request.*;
import com.hm.engine.manager.enums.ExamType;
import org.junit.Test;

import com.hm.engine.dao.suport.QueryUtil;
import org.w3c.dom.ls.LSException;

import javax.net.ssl.SSLServerSocket;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class PushServiceTest {
	PushService pushService=new PushService();


	@Test
	public void testPush() {
		
		DiseaseExamMapping labExamItem=new DiseaseExamMapping();
		labExamItem.setDiseaseCode("E78");
		labExamItem.setUserGuid("1");
		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "principalAction", labExamItem));
	}
	@Test
	public void testPushsss() {
		UserDiseaseRequest disease = new UserDiseaseRequest();
		disease.setUserGuid("xxxx");
		disease.setDiseaseSerialNumber(123l);

		List<UserDisease> userDiseases =Lists.newLinkedList();
		UserDisease userDisease = new UserDisease();
		userDisease.setDiseaseCode("E78.001");
		userDiseases.add(userDisease);
		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/services/", "saveUserDiseases", disease));
	}

	public static void main(String[] args) {
		UserExams use =new UserExams();
		use.setAscend(0);
		use.setDiseaseSerialNumber(123123l);
		use.setSortkey("examinationTime");
		QueryUtil uqQueryUtil =QueryUtil.getHqlByDomain(use);
		System.out.println(uqQueryUtil.getHql());
	}


	@Test
	public void UserProfile() {
		UserProfile userProfile =new UserProfile();
		userProfile.setAge(2);
		userProfile.setGender(1);
		userProfile.setProfession("江湖大佬");
		userProfile.setMaxWeight(100.0);
		userProfile.setWeight(80.0);
		userProfile.setHeight(172.0);
		userProfile.setMarried("生了一窝");

		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "saveUserProfile", userProfile));
	}
	@Test
	public void saveUserDisease() {
		UserDiseaseRequest request =new UserDiseaseRequest();
		UserDisease userDisease =new UserDisease();
		userDisease.setDiseaseCode("E78");
		userDisease.setUserGuid("xxxx");
		userDisease.setConfirmDiseaseTime(new Date());
		List<UserDisease> list = Lists.newArrayList();
		list.add(userDisease);
		request.setUserDiseases(list);

		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "saveUserDiseases", request));
	}
	@Test
	public void testFastJson(){
//		Group group2 = JSON.parseObject(jsonString, Group.class);
		UserDiseaseRequest userDisease=	JSON.parseObject(ConfigUtil.getByKey("test"), UserDiseaseRequest.class);
		System.out.print(userDisease.getUserDiseases().get(0).getConfirmDiseaseTime());
	}
	@Test
	public void saveUserUserExaminationItemObjectives(){
//		Group group2 = JSON.parseObject(jsonString, Group.class);
		UserExaminationItemObjectiveRequest request=new UserExaminationItemObjectiveRequest();

		List<UserExaminationItemObjective> sserAllergiesHistorys=Lists.newArrayList();

		UserExaminationItemObjective userExaminationItemObjective =new UserExaminationItemObjective();

		userExaminationItemObjective.setUserGuid("这是用户GUid");
		userExaminationItemObjective.setExaminationItem("这是指标代码，你需要查数据库，找出你要选的值");
		userExaminationItemObjective.setObjectiveMaxValue(100.0);

		userExaminationItemObjective.setObjectiveMaxValue(123.0);
		userExaminationItemObjective.setComments("这是个备注，你可以空着");
		sserAllergiesHistorys.add(userExaminationItemObjective);
		request.setUserExaminationItemObjectives(sserAllergiesHistorys);

		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "saveUserExaminationItemObjectives",request));

	}
	@Test
	public void saveUserExaminationListPrescriptions(){
//		Group group2 = JSON.parseObject(jsonString, Group.class);
		UserExaminationListPrescriptionRequest request=new UserExaminationListPrescriptionRequest();

		List<UserExaminationListPrescription> sserAllergiesHistorys=Lists.newArrayList();

		UserExaminationListPrescription userExaminationItemObjective =new UserExaminationListPrescription();

		userExaminationItemObjective.setUserGuid("这是用户GUid");

		userExaminationItemObjective.setDoctorGuid("医生ID");
		userExaminationItemObjective.setExamListId(12l);
		userExaminationItemObjective.setExamType(ExamType.everyDayExam);
		userExaminationItemObjective.setPrescriptionDate(new Date());
		sserAllergiesHistorys.add(userExaminationItemObjective);
		request.setUserExaminationListPrescriptions(sserAllergiesHistorys);
		System.out.println(pushService.push("http://localhost:8080/", "saveUserExaminationListPrescriptions", request));
	}

	@Test
	public void saveUserMedicationHistory() {
		UserMedicationHistoryRequest userDisease =new UserMedicationHistoryRequest();
		List<UserMedicationHistory> userMedicationHistories= Lists.newArrayList();
		userDisease.setUserMedicationHistories(userMedicationHistories);
		UserMedicationHistory u = new UserMedicationHistory();
		u.setDoctorGuid("xxdfadf");
		u.setUserGuid("用户ID");
		u.setBreakfastDosage("早餐，如是没有早中晚，就是计量");
		u.setLunchDosage("中午，剂量，可以为空");
		u.setDinnerDosage("晚上剂量，可以为空");
		u.setStartDate(new Date());
		u.setEndDae(new Date());
		u.setBeforeSleepDosage("睡前");
		u.setMedicationName("药品名称");
		userMedicationHistories.add(u);
//		return serviceFacade.saveUserMedicationHistory(userDisease);
		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "saveUserExaminationListPrescriptions", userDisease));

	}
	@Test
	public void UserSymptoms() {
		UserSymptomsRequest userDisease=new UserSymptomsRequest();
		List<UserSymptom> ls =Lists.newArrayList();
		userDisease.setUserSymptoms(ls);
		UserSymptom userSymptom =new UserSymptom();
		userSymptom.setUserGuid("用户GUID");
		userSymptom.setComments("备注");
		userSymptom.setConfirmTime(new Date());
		ls.add(userSymptom);
		System.out.println(pushService.push("http://localhost:8080/", "saveUserSymptoms", userDisease));
	}
	@Test
//	@RequestMapping(value = "/saveUserFamilyHealthHistorys", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
	public void saveUserFamilyHealthHistory() {
		UserFamilyHealthHistoryRequest userDisease =new UserFamilyHealthHistoryRequest();
		List<UserFamilyHealthHistory> userFamilyHealthHistories =Lists.newLinkedList();
		UserFamilyHealthHistory userFamilyHealthHistory=new UserFamilyHealthHistory();
		userDisease.setUserFamilyHealthHistories(userFamilyHealthHistories);
		userFamilyHealthHistory.setUserGuid("用户ID");
		userFamilyHealthHistory.setDiseaseCode("疾病COde");
		userFamilyHealthHistory.setComments("备注");
		userFamilyHealthHistories.add(userFamilyHealthHistory);
		System.out.println(pushService.push("http://localhost:8080/", "saveUserFamilyHealthHistorys", userDisease));
	}
	@Test
	public void saveUserAllergiesHistorys( ) {
		UserAllergiesHistoryRequest userDisease=new UserAllergiesHistoryRequest();
		List<UserAllergiesHistory> list =  Lists.newArrayList();
		userDisease.setUserAllergiesHistories(list);
		UserAllergiesHistory userAllergiesHistory =new UserAllergiesHistory();
		userAllergiesHistory.setComments("备注");
		userAllergiesHistory.setUserGuid("用户GUID");
		userAllergiesHistory.setAllergiesDate(new Date());
		userAllergiesHistory.setAllergyName("过敏名称");
		userAllergiesHistory.setServerity(UserAllergiesHistory.AllergiesSeverity.MODERATE);
		userAllergiesHistory.setReaction("反应，现象");
		userAllergiesHistory.setDiagnosed(true);
		list.add(userAllergiesHistory);
		System.out.println(pushService.push("http://localhost:8080/", "saveUserAllergiesHistorys", userDisease));
	}
	@Test
	public void  saveUserDaysNutritions() {
		UserDaysNutritionRequest userDisease =new UserDaysNutritionRequest();
		List<UserDaysNutrition> list = Lists.newArrayList();
		userDisease.setUserDaysNutritions(list);
		UserDaysNutrition userDaysNutrition =new UserDaysNutrition();
		userDaysNutrition.setUserGuid("用户ID");
		userDaysNutrition.setDoctorGuid("医生ID");
		userDaysNutrition.setComments("备注");
		userDaysNutrition.setAdi("");
		userDaysNutrition.setPrescriptionDate(new Date());
		list.add(userDaysNutrition);


		System.out.println(pushService.push("http://localhost:8080/", "saveUserDaysNutritions", userDisease));
	}

	@Test
	public void saveUserDaysSport() {
		UserDaysSport userDisease =new UserDaysSport();
		userDisease.setPrescriptionDate(new Date());
		userDisease.setComments("这是备注");
		userDisease.setUserGuid("asdf");
		userDisease.setDistance(123);
		userDisease.setContinusTime(23);
		userDisease.setDoctorGuid("doctorId");
		userDisease.setPrescriptionDate(new Date());
		System.out.println(pushService.push("http://localhost:8080/", "saveUserDaysNutritions", userDisease));
	}


	@Test
	public void saveUserSymptoms() {
		UserSymptomsRequest userDisease =new UserSymptomsRequest();
		UserSymptom userSymptom= new UserSymptom();
		List<UserSymptom> userSymptoms =Lists.newArrayList();
		userDisease.setUserSymptoms(userSymptoms);
		userSymptoms.add(userSymptom);
		userSymptom.setConfirmTime(new Date());
		userSymptom.setComments("这事备注");
		userSymptom.setSymptomName("症状名称");
		userSymptom.setRemission("如何缓解");
		userSymptom.setReason("原因");
		userSymptom.setDuration(123);
		userSymptom.setUserGuid("userGUid");
		//~
		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "saveUserSymptoms", userDisease));
	}@Test
	public void saveUserExams() {
		ListUserExams userDisease =new ListUserExams();
		userDisease.setUserGuid("userGUId");
		List<ExamItems> examItems =Lists.newArrayList();
		ExamItems item =new ExamItems();
		item.setExaminationItem("指标");
		item.setExaminationValue(120.0);
		examItems.add(item);
		userDisease.setExamItems(examItems);
		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "saveUserExams", userDisease));
	}


	@Test
	public void saveUserProfile() {
		UserProfile userProfile =new UserProfile();
		userProfile.setAge(2);
		userProfile.setGender(1);
		userProfile.setProfession("江湖大佬");
		userProfile.setMaxWeight(100.0);
		userProfile.setWeight(80.0);
		userProfile.setHeight(172.0);
		userProfile.setMarried("生了一窝");

		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "saveUserProfile", userProfile));
	}
	@Test
	public void updateUserProfile() {
		UserProfile userProfile =new UserProfile();
		userProfile.setDiseaseSerialNumber(123l);
		userProfile.setUserGuid("guid");
		userProfile.setAge(2);
		userProfile.setGender(1);
		userProfile.setProfession("江湖大佬");
		userProfile.setMaxWeight(100.0);
		userProfile.setWeight(80.0);
		userProfile.setHeight(172.0);
		userProfile.setMarried("生了一窝");

		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "updateUserProfile", userProfile));
	}
	@Test
	public void updateUserDisease() {
		UserDiseaseRequest request =new UserDiseaseRequest();
		request.setDiseaseSerialNumber(123l);
		request.setUserGuid("userGuid");
		UserDisease userDisease =new UserDisease();
		userDisease.setDiseaseCode("E78");
		userDisease.setUserGuid("xxxx");
		userDisease.setConfirmDiseaseTime(new Date());
		List<UserDisease> list = Lists.newArrayList();
		list.add(userDisease);
		request.setUserDiseases(list);

		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "updateUserDiseases", request));
	}

	@Test
	public void updateUserUserExaminationItemObjectives(){
//		Group group2 = JSON.parseObject(jsonString, Group.class);
		UserExaminationItemObjectiveRequest request=new UserExaminationItemObjectiveRequest();
		request.setDiseaseSerialNumber(123l);
		request.setUserGuid("userGuid");
		List<UserExaminationItemObjective> sserAllergiesHistorys=Lists.newArrayList();

		UserExaminationItemObjective userExaminationItemObjective =new UserExaminationItemObjective();

//		userExaminationItemObjective.setUserGuid("这是用户GUid");
		userExaminationItemObjective.setExaminationItem("这是指标代码，你需要查数据库，找出你要选的值");
		userExaminationItemObjective.setObjectiveMaxValue(100.0);

		userExaminationItemObjective.setObjectiveMaxValue(123.0);
		userExaminationItemObjective.setComments("这是个备注，你可以空着");
		sserAllergiesHistorys.add(userExaminationItemObjective);
		request.setUserExaminationItemObjectives(sserAllergiesHistorys);

		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "updateUserExaminationItemObjectives",request));

	}
	@Test
	public void updateUserExaminationListPrescriptions(){
//		Group group2 = JSON.parseObject(jsonString, Group.class);
		UserExaminationListPrescriptionRequest request=new UserExaminationListPrescriptionRequest();
		request.setDiseaseSerialNumber(123l);
		request.setUserGuid("userGuid");

		List<UserExaminationListPrescription> sserAllergiesHistorys=Lists.newArrayList();

		UserExaminationListPrescription userExaminationItemObjective =new UserExaminationListPrescription();

//		userExaminationItemObjective.setUserGuid("这是用户GUid");

		userExaminationItemObjective.setDoctorGuid("医生ID");
		userExaminationItemObjective.setExamListId(12l);
		userExaminationItemObjective.setExamType(ExamType.everyDayExam);
		userExaminationItemObjective.setPrescriptionDate(new Date());
		sserAllergiesHistorys.add(userExaminationItemObjective);
		request.setUserExaminationListPrescriptions(sserAllergiesHistorys);
		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "updateUserExaminationListPrescriptions", request));
	}

	@Test
	public void updateUserMedicationHistory() {
		UserMedicationHistoryRequest userDisease =new UserMedicationHistoryRequest();
		List<UserMedicationHistory> userMedicationHistories= Lists.newArrayList();
		userDisease.setUserGuid("用户Id");
		userDisease.setDiseaseSerialNumber(123l);
		userDisease.setUserMedicationHistories(userMedicationHistories);
		UserMedicationHistory u = new UserMedicationHistory();
		u.setDoctorGuid("xxdfadf");

		u.setBreakfastDosage("早餐，如是没有早中晚，就是计量");
		u.setLunchDosage("中午，剂量，可以为空");
		u.setDinnerDosage("晚上剂量，可以为空");
		u.setStartDate(new Date());
		u.setEndDae(new Date());
		u.setBeforeSleepDosage("睡前");
		u.setMedicationName("药品名称");
		userMedicationHistories.add(u);
//		return serviceFacade.saveUserMedicationHistory(userDisease);
		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "updateUserMedicationHistorys", userDisease));

	}
	@Test
	public void updateUserFamilyHealthHistory() {
		UserFamilyHealthHistoryRequest userDisease =new UserFamilyHealthHistoryRequest();
		userDisease.setDiseaseSerialNumber(123l);
		userDisease.setUserGuid("用户ID");
		List<UserFamilyHealthHistory> userFamilyHealthHistories =Lists.newLinkedList();
		UserFamilyHealthHistory userFamilyHealthHistory=new UserFamilyHealthHistory();
		userDisease.setUserFamilyHealthHistories(userFamilyHealthHistories);
		userFamilyHealthHistory.setDiseaseCode("疾病COde");
		userFamilyHealthHistory.setComments("备注");
		userFamilyHealthHistories.add(userFamilyHealthHistory);
		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "updateUserFamilyHealthHistorys", userDisease));
	}
	@Test
	public void updateUserAllergiesHistorys( ) {
		UserAllergiesHistoryRequest userDisease=new UserAllergiesHistoryRequest();
		userDisease.setDiseaseSerialNumber(123l);
		userDisease.setUserGuid("用户GUID");
		List<UserAllergiesHistory> list =  Lists.newArrayList();
		userDisease.setUserAllergiesHistories(list);
		UserAllergiesHistory userAllergiesHistory =new UserAllergiesHistory();
		userAllergiesHistory.setComments("备注");
		userAllergiesHistory.setAllergiesDate(new Date());
		userAllergiesHistory.setAllergyName("过敏名称");
		userAllergiesHistory.setServerity(UserAllergiesHistory.AllergiesSeverity.MODERATE);
		userAllergiesHistory.setReaction("反应，现象");
		userAllergiesHistory.setDiagnosed(true);
		list.add(userAllergiesHistory);
		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "updateUserAllergiesHistorys", userDisease));
	}
	@Test
	public void  updateUserDaysNutritions() {
		UserDaysNutritionRequest userDisease =new UserDaysNutritionRequest();
		userDisease.setDiseaseSerialNumber(123l);
		userDisease.setUserGuid("userGuid");
		List<UserDaysNutrition> list = Lists.newArrayList();
		userDisease.setUserDaysNutritions(list);
		UserDaysNutrition userDaysNutrition =new UserDaysNutrition();
		userDaysNutrition.setUserGuid("用户ID");
		userDaysNutrition.setDoctorGuid("医生ID");
		userDaysNutrition.setComments("备注");
		userDaysNutrition.setAdi("");
		userDaysNutrition.setPrescriptionDate(new Date());
		list.add(userDaysNutrition);


		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "updateUserDaysNutritions", userDisease));
	}

	@Test
	public void updateUserDaysSport() {
		UserDaysSport userDisease =new UserDaysSport();
		userDisease.setUserGuid("asdf");
		userDisease.setDiseaseSerialNumber(123l);
		userDisease.setPrescriptionDate(new Date());
		userDisease.setComments("这是备注");
		userDisease.setDistance(123);
		userDisease.setContinusTime(23);
		userDisease.setDoctorGuid("doctorId");
		userDisease.setPrescriptionDate(new Date());
		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "updateUserDaysNutritions", userDisease));
	}


	@Test
	public void updateUserSymptoms() {
		UserSymptomsRequest userDisease =new UserSymptomsRequest();
		userDisease.setUserGuid("userGUid");
		userDisease.setDiseaseSerialNumber(1234l);
		UserSymptom userSymptom= new UserSymptom();
		List<UserSymptom> userSymptoms =Lists.newArrayList();
		userDisease.setUserSymptoms(userSymptoms);
		userSymptoms.add(userSymptom);
		userSymptom.setConfirmTime(new Date());
		userSymptom.setComments("这事备注");
		userSymptom.setSymptomName("症状名称");
		userSymptom.setRemission("如何缓解");
		userSymptom.setReason("原因");
		userSymptom.setDuration(123);
//		userSymptom.setUserGuid("userGUid");
		//~
		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "updateUserSymptoms", userDisease));
	}@Test
	 public void updateUserExams() {
		ListUserExams userDisease =new ListUserExams();
		userDisease.setUserGuid("userGUId");
		userDisease.setDiseaseSerialNumber(123123l);


		List<ExamItems> examItems =Lists.newArrayList();
		ExamItems item =new ExamItems();
		item.setExaminationItem("指标");
		item.setExaminationValue(120.0);
		examItems.add(item);
		userDisease.setExamItems(examItems);


		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "updateUserExams", userDisease));
	}@Test
	 public void recomMedicationPrescriptionByDiseases() {
		UserChiefComplaint userChiefComplaint =new UserChiefComplaint();
		userChiefComplaint.setDiseaseCode("E78.001");

		System.out.println(pushService.push("http://10.1.1.86:8080/huimeitimes_engine_me/", "recomMedicationPrescriptionByDiseases", userChiefComplaint));
	}@Test
	 public void recomMedicationPrescriptionByUserGuidAndDiseaseSerialNumber() {
		UserDisease userDisease = new UserDisease();

		userDisease.setDiseaseSerialNumber(123l);
		userDisease.setUserGuid("xxxx");
		System.out.println(pushService.push("http://localhost:8080/huimeitimes_engine_me/", "recomMedicationPrescriptionByUserGuidAndDiseaseSerialNumber", userDisease));
	}
}
