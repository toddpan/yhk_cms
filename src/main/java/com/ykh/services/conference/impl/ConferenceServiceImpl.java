package com.ykh.services.conference.impl;

import com.maxc.rest.common.ConfigUtil;
import com.maxc.rest.common.exception.RestException;
import com.ykh.common.Constants;
import com.ykh.common.YkhUtils;
import com.ykh.services.conference.ConferenceSeedService;
import com.ykh.services.conference.exception.CMSErrorCode;
import com.ykh.dao.conference.ConfJoinTempConfDao;
import com.ykh.dao.conference.ConferenceDao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.services.conference.ConferenceService;
import com.ykh.tang.agent.ICMSAgentInterface;
import com.ykh.tang.agent.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.user.domain.User;

@Service
public  class ConferenceServiceImpl implements ConferenceService {
	Logger logger=Logger.getLogger(ConferenceService.class);
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
		logger.info("createConference===> enter");
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
		confInfo.setConfID(seed);
		confInfo.setName(conference.getConferencename());
//		confInfo.setPassword(conference.getPassword());
		confInfo.setStopParams(dao.getAutoStopParams());
//		confInfo.setRoleInfo(dao.get);
		confInfo.setRoleInfo(dao.getRuleInfos().getRoleInfo());

		long startSenconde = 0l;
		if(conference.getStarttime()==null){

			 startSenconde = System.currentTimeMillis()/1000;

		}else {
			startSenconde=conference.getStarttime().getTime()/1000;
		}

		confInfo.setPlanStartTime0((int) startSenconde & 0xFFFFFFFF);
		confInfo.setPlanStartTime1((int)startSenconde>>32 & 0xffffffff);

		long endTimeSeconds=0;
		if(conference.getEndTime()==null){
			endTimeSeconds = (System.currentTimeMillis() + 24*60*60*1000)/1000;

		}else {
			endTimeSeconds=(conference.getEndTime().getTime()/1000);
		}

		confInfo.setPlanStartTime0((int)endTimeSeconds& 0xFFFFFFFF);
		confInfo.setPlanStartTime1((int)endTimeSeconds>>32 & 0xffffffff);
		confInfo.setServiceConfigs(dao.getServiceConfigs().getServiceConfigs());
		confInfo.setConfScale(dao.getConfScale());
		confInfo.setBillingCode(dao.getBillingcode() + "");
//		confInfo.setSubConference();
		//TODO 空的子会议
		SubConferenceInfo subConfInfo = new SubConferenceInfo();
		subConfInfo.setServiceConfigArr(dao.getServiceConfigs().getServiceConfigs());
		subConfInfo.setRoleInfoArr(dao.getRuleInfos().getRoleInfo());
		confInfo.setSubConference(subConfInfo);
		icmsAgent.createConferenceWithoutUser(Constants.site, confInfo, YkhUtils.getAllServicetypelist());
		confJoinTempConfDao.save(confJoinTempConf);
		//开会
		logger.info("createConference===> end");
		return  confInfo;
	}
	@Override
	public Boolean stopConference(String applicationID, Integer tempConferenceID)
			throws RuntimeException {
		ConfJoinTempConf confJoinTempConf= confJoinTempConfDao.findByTempConfId(tempConferenceID);
		if(confJoinTempConf.getBmsStatus()!=2){
			RestException restException = new RestException();
			restException.setErrorCode(CMSErrorCode.CONFERENCE_NOT_FOUND.value());
			restException.setMessage(CMSErrorCode.CONFERENCE_NOT_FOUND.getDescription());
			throw restException;
		}
		if(confJoinTempConf.getBmsStatus()==3){
			return true;
		}else{
			icmsAgent.startConferenceWithoutUser(Constants.site,tempConferenceID);
			confJoinTempConf.setBmsStatus(3);
			confJoinTempConfDao.save(confJoinTempConf);
		}
		icmsAgent.stopConferenceWithoutUser(Constants.site,tempConferenceID);
		return true;
	}

	@Override
	public Boolean deleteConference(String applicationID, Integer conferenceID)
			throws RuntimeException {
		confJoinTempConfDao.delete(confJoinTempConfDao.findByTempConfId(conferenceID));
		icmsAgent.deleteConferenceWithoutUser(Constants.site, conferenceID);
		return true;
	}

	@Override
	public Integer queryUserNum(String applicationID, Integer tempConfID)
			throws Exception {

		return null;
	}

	@Override
	public Boolean startConference(Integer tempConferenceID)  {
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
			icmsAgent.startConferenceWithoutUser(Constants.site,tempConferenceID);
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
