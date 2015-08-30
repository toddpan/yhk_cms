package com.ykh.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.maxc.rest.common.exception.RestException;
import com.ykh.common.BeanTranslatorUtil;
import com.ykh.common.Constants;
import com.ykh.common.YkhUtils;
import com.ykh.conference.service.ConferenceService;
import com.ykh.conference.service.exception.CMSErrorCode;
import com.ykh.dao.conference.ConfJoinTempConfDao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.user.TempUserDao;
import com.ykh.dao.user.domain.TempUser;
import com.ykh.exception.UserInfoException;
import com.ykh.pojo.User;
import com.ykh.tang.agent.ICMSAgentInterface;
import com.ykh.tang.agent.message.UserInfo;
import com.ykh.tang.agent.vo.BMSUserInfo;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.user.service.UserConferenceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
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
    public UserChannel userJoinConference(User request) {
        logger.info("UserConferenceServiceImpl ==>"+ JSON.toJSONString(request));
        TempUser tempUser= tempUserDao.findByUsername(request.getUsername());
        BMSUserInfo userInfo =new BMSUserInfo();
        if(tempUser!=null){
            Integer conft= tempUser.getTempConferenceId();
          ConfJoinTempConf confJoinTempConf= confJoinTempConfDao.findByTempConfId(request.getTempConferenceId());
            if(confJoinTempConf!=null&&confJoinTempConf.getBmsStatus()!=2){
                RestException restException =new RestException();
                restException.setMessage(CMSErrorCode.CONFERENCE_NOT_FOUND.getDescription());
                restException.setErrorCode(CMSErrorCode.CONFERENCE_NOT_FOUND.value());
                throw  restException;
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
        }

        tempUser.setUserId(request.getSeqNo());
        tempUser.setUsername(request.getUsername());
        tempUser.setStatus(request.getUserStatus()==null ? 0:request.getUserStatus());
        tempUser.setTempConferenceId(request.getTempConferenceId());
        tempUserDao.save(tempUser);
        request.setTempuserid(tempUser.getIdTempUser());
        try {
        userInfo=    BeanTranslatorUtil.copyUser2UserInfo(request);
        }catch (Exception e){
            e.printStackTrace();
            RestException  r = new RestException();
            r.setErrorCode(UserInfoException.ERROR_CODE);
            r.setMessage(UserInfoException.message+" "+e.getMessage());
            throw r;
        }

        logger.info("userJoinConference  ===>" + request.getTempConferenceId());

        UserChannel userChannel=  icmsAgent.userJoinConference(Constants.site,request.getTempConferenceId(), userInfo);
        tempUser.setPinCode(userInfo.pinCode);
        tempUser.setClientType(userInfo.getClientType());
        tempUser.setUserChannel(userChannel);
        //修改
        tempUserDao.save(tempUser);
        userChannel.setTempConferenceID(request.getTempConferenceId());
        userChannel.setUserID(tempUser.getUserId());
        logger.info("UserConferenceServiceImpl ==> end." + JSON.toJSONString(userChannel));

        return userChannel;
    }
}
