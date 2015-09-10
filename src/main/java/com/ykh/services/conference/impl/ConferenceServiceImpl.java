package com.ykh.services.conference.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.maxc.rest.common.ConfigUtil;
import com.maxc.rest.common.RestBeanUtils;
import com.maxc.rest.common.exception.ResourceNoFoundException;
import com.maxc.rest.common.exception.RestAssert;
import com.maxc.rest.common.exception.RestException;
import com.ykh.common.BeanTranslatorUtil;
import com.ykh.common.Constants;
import com.ykh.common.IPTranslatorUtil;
import com.ykh.common.YkhUtils;
import com.ykh.dao.Dao;
import com.ykh.dao.conference.ConferenceSeedDao;
import com.ykh.dao.conference.domain.ConferenceSeed;
import com.ykh.dao.user.TempUserDao;
import com.ykh.dao.user.domain.TempUser;
import com.ykh.pojo.*;
import com.ykh.services.conference.ConferenceSeedService;
import com.ykh.services.conference.exception.CMSErrorCode;
import com.ykh.dao.conference.ConfJoinTempConfDao;
import com.ykh.dao.conference.ConferenceDao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.services.conference.ConferenceService;
import com.ykh.tang.agent.*;
import com.ykh.tang.agent.vo.*;
import com.ykh.vo.res.PageResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ykh.dao.conference.domain.Conference;

import java.util.List;

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
	@Autowired
	private ConferenceSeedDao conferenceSeedDao;
	@Autowired
	private TempUserDao tempUserDao;
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
		confInfo.setRoleInfo(dao.getRuleInfos());

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
		confInfo.setServiceConfigs(dao.getServiceConfigs());
		confInfo.setConfScale(dao.getConfScale());
		confInfo.setBillingCode(dao.getBillingcode() + "");
//		confInfo.setSubConference();
		//TODO 空的子会议
		SubConferenceInfo subConfInfo = new SubConferenceInfo();
		subConfInfo.setServiceConfigArr(dao.getServiceConfigs());
		subConfInfo.setRoleInfoArr(dao.getRuleInfos());
		confInfo.setSubConference(subConfInfo);
		icmsAgent.createConferenceWithoutUser(Constants.site, confInfo, YkhUtils.getAllServicetypelist());
		confJoinTempConfDao.save(confJoinTempConf);
		//开会
		logger.info("createConference===> end"+ JSON.toJSONString(confInfo));
		return  confInfo;
	}
	@Override
	public Boolean stopConference(String applicationID, Integer tempConferenceID)
			throws RuntimeException {
		ConferenceSeed conferenceSeed =conferenceSeedDao.findOne(tempConferenceID);
		if(conferenceSeed==null){
			throw new ResourceNoFoundException();
		}
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
		icmsAgent.stopConferenceWithoutUser(Constants.site, tempConferenceID);
		return true;
	}

	@Override
	public Boolean deleteConference(String applicationID, Integer conferenceID)
			throws RuntimeException {
		ConferenceSeed conferenceSeed =conferenceSeedDao.findOne(conferenceID);
		if(conferenceSeed==null){
			throw new ResourceNoFoundException();
		}
		confJoinTempConfDao.delete(confJoinTempConfDao.findByTempConfId(conferenceID));
		icmsAgent.deleteConferenceWithoutUser(Constants.site, conferenceID);
		return true;
	}

	@Override
	public Integer queryUserNum(Integer tempConfID)
			throws Exception {

		return 0;
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

	/**
	 * 保存会议模版
	 * @param conference
	 */
	@Override
	public void openConference(Conference conference) {
		conferenceDao.save(conference);
	}

	@Override
	public Conference modifyConference(Conference conference) {
		Conference dao =conferenceDao.findOne(conference.getConferenceId());
		RestAssert.notNull(Conference.class, dao);
		RestBeanUtils.copyProperties(dao, conference, false);
		conferenceDao.save(dao);

		return  dao;
	}



		@Override
		public UserServiceDTO userJoinConference(User request) {
			logger.info("UserConferenceServiceImpl ==>"+ JSON.toJSONString(request));
			TempUser tempUser=null;
			if(request.getTempuserid()!=null)
				tempUser= tempUserDao.find(request.getTempuserid());
			BMSUserInfo userInfo =new BMSUserInfo();
			if(tempUser!=null){
				Integer conft= tempUser.getTempConferenceId();
				ConfJoinTempConf confJoinTempConf= confJoinTempConfDao.findByTempConfId(request.getTempConferenceId());
				if(confJoinTempConf!=null&&confJoinTempConf.getBmsStatus()!=2){
					return tempUser.getUserChannel();
				}
				//
				if(conft!=request.getTempConferenceId()){
					tempUserDao.delete(tempUserDao.findByUsername(request.getUsername()));
					List<String> userArr = Lists.newLinkedList();
					userArr.add(tempUser.getIdTempUser()+"");
					icmsAgent.expelUser(Constants.site,conft, userArr);
				}
			}else{
				tempUser = new TempUser();
				tempUser.setUserId(request.getSeqNo());
				tempUser.setUsername(request.getUsername());
				tempUser.setStatus(request.getUserStatus()==null ? 0:request.getUserStatus());
				tempUser.setTempConferenceId(request.getTempConferenceId());
				tempUserDao.save(tempUser);
			}
			request.setTempuserid(tempUser.getIdTempUser());
			try {
				userInfo= BeanTranslatorUtil.copyUser2UserInfo(request);
			}catch (Exception e) {
				e.printStackTrace();
				RestException  r = new RestException();
				r.setErrorCode(com.ykh.tang.agent.Consts.ERROR_CODE);
				r.setMessage(com.ykh.tang.agent.Consts.message+" "+e.getMessage());
				throw r;
			}

			logger.info("userJoinConference  ===> jni start" + request.getTempConferenceId());
			UserServiceDTO dto=new UserServiceDTO();
			UserChannel userChannel = icmsAgent.userJoinConference(Constants.site, request.getTempConferenceId(), userInfo);
			tempUser.setPinCode(userInfo.pinCode);
			tempUser.setClientType(userInfo.getClientType());
			//修改
			tempUser.setUserChannel(dto);
			tempUserDao.save(tempUser);
			//logger.info("userJoinConference  ===> jni end UserChannel" + ParseJSON.toJson(userChannel));
			userChannel.setTempConferenceID(request.getTempConferenceId());
			UserDTO userDTO= new UserDTO();
			userDTO.setTempuserid(tempUser.getIdTempUser());
			RestBeanUtils.copyProperties(userDTO, request, false);
			userDTO.setTempuserid(tempUser.getIdTempUser());
			dto.setUser(userDTO);
			List<CtServiceAddrDTO> list= Lists.newArrayList();
			for (UserServiceAddr ctServiceAddr:userChannel.getCtsAddr()){
				CtServiceAddrDTO ctServiceAddrDTO=new CtServiceAddrDTO();
				String accessip= IPTranslatorUtil.longToIP(ctServiceAddr.getServerIP0());
				String bakaccessip=	IPTranslatorUtil.longToIP(ctServiceAddr.getHotServerIP0());
				ctServiceAddrDTO.setAccessip(accessip);
				ctServiceAddrDTO.setBakassessip(bakaccessip);
				ctServiceAddrDTO.setGroupID(ctServiceAddr.groupID);
				ctServiceAddrDTO.setChannelID(ctServiceAddr.getChannel());
				ctServiceAddrDTO.setType(ctServiceAddr.getServiceType());

				list.add(ctServiceAddrDTO);
			}
			List<DtServiceAddrDTO> dtServiceAddrDTOs= Lists.newArrayList();
//        for (UserServiceAddr dtServiceAddr:userChannel.getDtsAddr()){
//            DtServiceAddrDTO dtServiceAddrDTO=new DtServiceAddrDTO();
//            String accessip= IPTranslatorUtil.longToIP(dtServiceAddr.getServerIP0());
//            String bakaccessip=	IPTranslatorUtil.longToIP(dtServiceAddr.getHotServerIP0());
//            dtServiceAddrDTO.setAccessip(accessip);
//            dtServiceAddrDTO.setBakassessip(bakaccessip);
//            dtServiceAddrDTOs.add(ctServiceAddrDTO);
//        }
			dto.setTempconfernceid(userChannel.getTempConferenceID());
//        dto.setDtsaddrlist();
			dto.setCtsaddrlist(list);
			dto.setTempconfernceid(request.getTempConferenceId());

			return dto;
		}

	@Override
	public Dao.PageVO<Conference> searchConference(Conference conference) {

		return 		conferenceDao.findPages(conference);

	}

	public  static  void  main(String[] args){
		System.out.print(JSON.toJSONString(new PageRequest(1,1)));
	}

}
