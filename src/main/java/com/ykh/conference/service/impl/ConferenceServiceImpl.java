package com.ykh.conference.service.impl;

import com.google.common.collect.Lists;
import com.maxc.rest.common.ConfigUtil;
import com.ykh.common.YkhUtils;
import com.ykh.conference.service.ConferenceSeedService;
import com.ykh.dao.conference.ConfJoinTempConfDao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.tang.agent.ICMSAgent;
import com.ykh.tang.agent.excep.CMSException;
import com.ykh.tang.agent.vo.ConferenceInfoBMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ykh.conference.service.ConferenceService;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.user.domain.User;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.tang.agent.vo.UserConferenceStatus;

import java.util.List;

@Service
public  class ConferenceServiceImpl implements ConferenceService {
	@Autowired
	ConferenceSeedService conferenceSeedService;
	@Autowired
	ConfJoinTempConfDao confJoinTempConfDao;
	@Autowired
	ICMSAgent icmsAgent;
	@Override
	public ConferenceInfoBMS createConference( Conference conference) throws RuntimeException {
		Integer seed=conference.getTempConferenceId();
		if(seed!=null){
			ConfJoinTempConf confJoinTempConf= confJoinTempConfDao.findByBmsStatusLessThanAndTempConfIdAndConfId(3, seed, conference.getConferenceId());
			if(confJoinTempConf!=null){
				ConferenceInfoBMS confInfo =new  ConferenceInfoBMS();
				Integer integer=icmsAgent.getConfInfo(Integer.parseInt(ConfigUtil.getByKey("site")), conference.getConferenceId(), confInfo);
				return  confInfo;
			}
		}
		seed =conferenceSeedService.getConfTempId(conference.getConferenceId(), conference.getConferencename());
		ConfJoinTempConf confJoinTempConf=new ConfJoinTempConf.Bulider().bmsStatus(1).tempConfId(seed).confId(conference.getConferenceId()).create();
		ConferenceInfoBMS confInfo =new ConferenceInfoBMS();

		icmsAgent.createConferenceWithoutUser(Integer.parseInt(ConfigUtil.getByKey("site")),confInfo, YkhUtils.getAllServicetypelist());

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
	public Boolean startConference(String applicationID,
			Integer tempConferenceID) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}



}
