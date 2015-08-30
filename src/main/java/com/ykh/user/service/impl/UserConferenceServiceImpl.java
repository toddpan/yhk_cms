package com.ykh.user.service.impl;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

/**
 * Created by ant_shake_tree on 15/8/27.
 */
@Service
public class UserConferenceServiceImpl implements UserConferenceService {
    @Autowired
    ICMSAgentInterface icmsAgent;
    @Autowired
    TempUserDao tempUserDao;
    @Autowired
    ConfJoinTempConfDao confJoinTempConfDao;
    @Override
    public UserChannel userJoinConference(User request) {
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
                icmsAgent.expelUser(Constants.site,conft, YkhUtils.getAllServicetypelist());
            }
        }else{
            tempUser = new TempUser();
        }
        tempUser.setUserId(request.getSeqNo());
        tempUser.setUsername(request.getUsername());
        tempUser.setStatus(1);
        tempUser.setTempConferenceId(request.getTempConferenceId());
        tempUserDao.save(tempUser);

        try {
        userInfo=    BeanTranslatorUtil.copyUser2UserInfo(request);
        }catch (Exception e){
            RestException  r = new RestException();
            r.setErrorCode(UserInfoException.ERROR_CODE);
            r.setMessage(UserInfoException.message);
            throw r;
        }

        UserChannel userChannel=  icmsAgent.userJoinConference(Constants.site,request.getTempConferenceId(), userInfo);
        tempUser.setPinCode(userInfo.pinCode);
        tempUser.setClientType(userInfo.getClientType());
        tempUser.setUserChannel(userChannel);
        //修改
        tempUserDao.save(tempUser);
        userChannel.setTempConferenceID(request.getTempConferenceId());
        userChannel.setUserID(tempUser.getUserId());
        return userChannel;
    }
}
