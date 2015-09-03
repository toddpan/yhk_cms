package com.ykh.services.user.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.maxc.rest.common.RestBeanUtils;
import com.maxc.rest.common.exception.RestException;
import com.ykh.common.BeanTranslatorUtil;
import com.ykh.common.Constants;
import com.ykh.common.IPTranslatorUtil;
import com.ykh.pojo.*;
import com.ykh.dao.conference.ConfJoinTempConfDao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.dao.user.TempUserDao;
import com.ykh.dao.user.domain.TempUser;
import com.ykh.services.user.UserConferenceService;
import com.ykh.tang.agent.Consts;
import com.ykh.tang.agent.ICMSAgentInterface;
import com.ykh.tang.agent.vo.BMSUserInfo;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.tang.agent.vo.UserServiceAddr;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ant_shake_tree on 15/8/27.
 */
@Service
public class UserConferenceServiceImpl implements UserConferenceService {
    Logger logger =Logger.getLogger(UserConferenceService.class);
    @Autowired
    ICMSAgentInterface icmsAgent;
    @Autowired
    TempUserDao tempUserDao;
    @Autowired
    ConfJoinTempConfDao confJoinTempConfDao;
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
            r.setErrorCode(Consts.ERROR_CODE);
            r.setMessage(Consts.message+" "+e.getMessage());
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
    private long intToLong(int a){
        return a*1l;
    }
}
