package com.ykh.conference.service.impl;

import org.springframework.stereotype.Service;

import com.ykh.conference.service.ConferenceService;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.user.domain.User;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.tang.agent.vo.UserConferenceStatus;

@Service
public  class ConferenceServiceImpl implements ConferenceService {
	@Override
	public Boolean createConference(Integer applicationID,
			Integer tempConferenceID, Conference conference) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean stopConference(String applicationID, Integer tempConferenceID)
			throws Exception {
		// TODO Auto-generated method stub
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
