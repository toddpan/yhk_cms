package com.ykh.conference.service.impl;

import com.google.common.collect.Lists;
import com.maxc.rest.common.ConfigUtil;
import com.maxc.rest.common.exception.RestException;
import com.ykh.common.Constants;
import com.ykh.common.YkhUtils;
import com.ykh.conference.service.ConferenceSeedService;
import com.ykh.conference.service.exception.CMSErrorCode;
import com.ykh.dao.conference.ConfJoinTempConfDao;
import com.ykh.dao.conference.ConferenceDao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.tang.agent.ICMSAgent;
import com.ykh.tang.agent.ICMSAgentInterface;
import com.ykh.tang.agent.excep.CMSException;
import com.ykh.tang.agent.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ykh.conference.service.ConferenceService;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.user.domain.User;

import java.util.ArrayList;
import java.util.List;

@Service
public  class ConferenceServiceImpl implements ConferenceService {
	@Autowired
	ConferenceSeedService conferenceSeedService;
	@Autowired
	ConfJoinTempConfDao confJoinTempConfDao;
	@Autowired
	private ICMSAgentInterface icmsAgent;
	@Autowired
	private ConferenceDao conferenceDao;


	@Override
	public ConferenceInfoBMS createConference( Conference conference) throws RuntimeException {
		Integer seed=conference.getTempConferenceId();
		if(seed!=null){
			ConfJoinTempConf confJoinTempConf= confJoinTempConfDao.findByBmsStatusLessThanAndTempConfIdAndConfId(3, seed, conference.getConferenceId());
			if(confJoinTempConf!=null){
				ConferenceInfoBMS confInfo=icmsAgent.getConfInfo(Integer.parseInt(ConfigUtil.getByKey("site")), conference.getConferenceId());
				return  confInfo;
			}
		}
		seed =conferenceSeedService.getConfTempId(conference.getConferenceId(), conference.getConferencename());
		ConfJoinTempConf confJoinTempConf=new ConfJoinTempConf.Bulider().bmsStatus(1).tempConfId(seed).confId(conference.getConferenceId()).create();
		ConferenceInfoBMS confInfo =new ConferenceInfoBMS();
		Conference dao = conferenceDao.find(conference.getConferenceId());
		confInfo.setConfID(dao.getConferenceId());
		confInfo.setName(conference.getConferencename());
//		confInfo.setPassword(conference.getPassword());
		confInfo.setStopParams(dao.getAutoStopParams());
//		confInfo.setRoleInfo(dao.get);
		confInfo.setRoleInfo(dao.getRuleInfos().getRoleInfo());
		confInfo.setServiceConfigs(dao.getServiceConfigs().getServiceConfigs());
		confInfo.setConfScale(dao.getConfScale());
		confInfo.setBillingCode(dao.getBillingcode() + "");
//		confInfo.setSubConference();
		//TODO 空的子会议
		SubConferenceInfo subConfInfo = new SubConferenceInfo();
		List<String> subServConfArr = new ArrayList<String>();
		subConfInfo.setServiceConfigArr(subServConfArr);
		List<RoleInfo> subRoleInfoArr = new ArrayList<RoleInfo>();
		subConfInfo.setRoleInfoArr(subRoleInfoArr);
		// SubConferenceInfo subConfInfo = null;
		confInfo.setSubConference(subConfInfo);
		icmsAgent.createConferenceWithoutUser(Constants.site, confInfo, YkhUtils.getAllServicetypelist());
		confJoinTempConfDao.save(confJoinTempConf);
		//开会
		return  confInfo;
	}
	@Override
	public Boolean stopConference(String applicationID, Integer tempConferenceID)
			throws Exception {
//		icmsAgent.stopConferenceWithoutUser(tempConferenceID);
		return null;
	}

	@Override
	public Boolean deleteConference(String applicationID, Integer conferenceID)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer queryUserNum(String applicationID, Integer tempConfID)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean startConference(Integer tempConferenceID)  {
		// TODO Auto-generated method stub
		ConfJoinTempConf confJoinTempConf= confJoinTempConfDao.findByTempConfId(tempConferenceID);
		if(confJoinTempConf.getBmsStatus()>2){
			RestException restException = new RestException();
			restException.setErrorCode(CMSErrorCode.CONFERENCE_NOT_FOUND.value());
			restException.setMessage(CMSErrorCode.CONFERENCE_NOT_FOUND.getDescription());
			throw restException;
		}
		if(confJoinTempConf.getBmsStatus()==2){
			return true;
		}else{
			icmsAgent.startConferenceWithoutUser(Integer.parseInt("site"),tempConferenceID);
			confJoinTempConf.setBmsStatus(2);
			confJoinTempConfDao.save(confJoinTempConf);
		}
		return true;
	}

	@Override
	public UserChannel joinConference(String applicationID,
			Integer tempConferenceID, User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getBMSConferenceInfo(String applicationID, Integer tempConfID)
			throws Exception {
		// TODO Auto-generated method stub
//		icmsAgent.get
		return null;
	}

	@Override
	public UserConferenceStatus getUserConferenceStatus(String applicationID,
			Integer tempConfID, Integer tempUserID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer createConference(String applicationID, String billingCode)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer initConference(String applicationID, Integer conferenceID)
			throws Exception {
		return null;
	}

public  static void main(String[] args){
	System.out.print(ConfigUtil.getByKey("site"));
}

}
