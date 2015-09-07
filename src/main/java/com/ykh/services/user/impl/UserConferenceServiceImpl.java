//package com.ykh.services.user.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.google.common.collect.Lists;
//import com.maxc.rest.common.RestBeanUtils;
//import com.maxc.rest.common.exception.RestException;
//import com.ykh.common.BeanTranslatorUtil;
//import com.ykh.common.Constants;
//import com.ykh.common.IPTranslatorUtil;
//import com.ykh.pojo.*;
//import com.ykh.dao.conference.ConfJoinTempConfDao;
//import com.ykh.dao.conference.domain.ConfJoinTempConf;
//import com.ykh.dao.user.TempUserDao;
//import com.ykh.dao.user.domain.TempUser;
//import com.ykh.services.user.UserConferenceService;
//import com.ykh.tang.agent.Consts;
//import com.ykh.tang.agent.ICMSAgentInterface;
//import com.ykh.tang.agent.vo.BMSUserInfo;
//import com.ykh.tang.agent.vo.UserChannel;
//import com.ykh.tang.agent.vo.UserServiceAddr;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by ant_shake_tree on 15/8/27.
// */
//@Service
//public class UserConferenceServiceImpl implements UserConferenceService {
//    Logger logger =Logger.getLogger(UserConferenceService.class);
//    @Autowired
//    ICMSAgentInterface icmsAgent;
//    @Autowired
//    TempUserDao tempUserDao;
//    @Autowired
//    ConfJoinTempConfDao confJoinTempConfDao;
//    @Override
//    public UserServiceDTO userJoinConference(User request) {
//        logger.info("UserConferenceServiceImpl ==>"+ JSON.toJSONString(request));
//        TempUser tempUser=null;
//        if(request.getTempuserid()!=null)
//             tempUser= tempUserDao.find(request.getTempuserid());
//        BMSUserInfo userInfo =new BMSUserInfo();
//        if(tempUser!=null){
//            Integer conft= tempUser.getTempConferenceId();
//            ConfJoinTempConf confJoinTempConf= confJoinTempConfDao.findByTempConfId(request.getTempConferenceId());
//            if(confJoinTempConf!=null&&confJoinTempConf.getBmsStatus()!=2){
//                return tempUser.getUserChannel();
//            }
//            //
//            if(conft!=request.getTempConferenceId()){
//                tempUserDao.delete(tempUserDao.findByUsername(request.getUsername()));
//                List<String> userArr = Lists.newLinkedList();
//                userArr.add(tempUser.getIdTempUser()+"");
//                icmsAgent.expelUser(Constants.site,conft, userArr);
//            }
//        }else{
//            tempUser = new TempUser();
//            tempUser.setUserId(request.getSeqNo());
//            tempUser.setUsername(request.getUsername());
//            tempUser.setStatus(request.getUserStatus()==null ? 0:request.getUserStatus());
//            tempUser.setTempConferenceId(request.getTempConferenceId());
//            tempUserDao.save(tempUser);
//        }
//        request.setTempuserid(tempUser.getIdTempUser());
//        try {
//        userInfo= BeanTranslatorUtil.copyUser2UserInfo(request);
//        }catch (Exception e) {
//            e.printStackTrace();
//            RestException  r = new RestException();
//            r.setErrorCode(Consts.ERROR_CODE);
//            r.setMessage(Consts.message+" "+e.getMessage());
//            throw r;
//        }
//
//        logger.info("userJoinConference  ===> jni start" + request.getTempConferenceId());
//        UserChannel userChannel = icmsAgent.userJoinConference(Constants.site, request.getTempConferenceId(), userInfo);
//
//        userChannel.setTempConferenceID(request.getTempConferenceId());
//
//        UserDTO userDTO= new UserDTO();
//
//        userDTO.setTempuserid(tempUser.getIdTempUser());
//
//        RestBeanUtils.copyProperties(userDTO, request, false);
//
//        tempUser.setPinCode(userInfo.pinCode);
//
//        tempUser.setClientType(userInfo.getClientType());
//
//        tempUserDao.save(tempUser);
//
//        UserServiceDTO dto = getUserServiceByChannel(userChannel, userDTO);
//
//        tempUser.setUserChannel(dto);
//
//        return dto;
//    }
//
//private UserServiceDTO getUserServiceByChannel(UserChannel userChannel, UserDTO userDTO)
//{
//	if(userChannel.getUserID() > 0)
//	{
//		userDTO.setTempuserid(Integer.valueOf(userChannel.getUserID()));
//	}
//	UserServiceDTO userServiceDTO = new UserServiceDTO();
//
//	userServiceDTO.setTempconfernceid(userChannel.getTempConferenceID());
//
//	userServiceDTO.setUser(userDTO);
//
//	String userIpaddr = userDTO.getIpaddr();
//
//	logger.info("userIpaddr from userDTO is:" + userIpaddr);
//
//	List<DtServiceAddrDTO> dtsaddrDTOlist = new ArrayList<DtServiceAddrDTO>();
//
//	if (userChannel.ctsAddr == null || userChannel.ctsAddr.isEmpty())
//
//	{
//
//	logger.error("业务管理返回的ctsAddr地址列表为空！调用中断，直接返回NULL！");
//
//	throw new NullPointerException("业务管理返回的ctsAddr地址列表为空！调用中断，直接返回NULL！");
//
//	}
//
//	if (userChannel.dtsAddr == null || userChannel.dtsAddr.isEmpty())
//
//	{
//
//	logger.error("业务管理返回的dtsAddr地址列表为空！");
//
//	dtsaddrDTOlist = null;
//
//	} else
//
//	{
//
//		DtServiceAddrDTO usAddrDto = null;
//
//		for (UserServiceAddr usaddr : userChannel.dtsAddr)
//		{
//
//
//			usAddrDto = new DtServiceAddrDTO();
//
//			usAddrDto.setChannelID(intToLong(usaddr.channel));
//
//			usAddrDto.setGroupID(intToLong(usaddr.groupID));
//
//			usAddrDto.setType(intToLong(usaddr.serviceType));
//
//			usAddrDto.setTransportip(IPTranslatorUtil.longToIP(usaddr.getServerIP0()));
//
//
//			dtsaddrDTOlist.add(usAddrDto);
//
//		}
//
//	}
//
//	userServiceDTO.setDtsaddrlist(dtsaddrDTOlist);
//
//	List<CtServiceAddrDTO> ctsaddrDTOlist = new ArrayList<CtServiceAddrDTO>();
//
//	CtServiceAddrDTO csAddrDto = null;
//
//	for (UserServiceAddr usaddr : userChannel.ctsAddr)
//	{
//
//		csAddrDto = new CtServiceAddrDTO();
//
//		csAddrDto.setType((usaddr.serviceType));
//
//		csAddrDto.setChannelID((usaddr.channel));
//
//		csAddrDto.setGroupID((usaddr.groupID));
//
//		csAddrDto.setAccessip(IPTranslatorUtil.longToIP(usaddr.getServerIP0()));
//
//		csAddrDto.setBakassessip(IPTranslatorUtil.longToIP(usaddr.getHotServerIP0()));
//
//		if(csAddrDto != null)
//		{
//
//			logger.info("Accessip is:" + csAddrDto.getAccessip());
//
//			logger.info("Bakessessip is:" + csAddrDto.getBakassessip());
//
//			ctsaddrDTOlist.add(csAddrDto);
//		}
//
//	}
//
//	userServiceDTO.setCtsaddrlist(ctsaddrDTOlist);
//
//	return userServiceDTO;
//
//}
//
//
//
///**
//
//* int类型数据转long
//
//* @param value
//
//* @return
//
//*/
//
//private long intToLong(int value){
//
//return value * 1l;
//
//}
//}
