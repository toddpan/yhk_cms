package com.ykh.user.service.impl;

import com.maxc.rest.common.exception.RestException;
import com.ykh.common.Constants;
import com.ykh.common.YkhUtils;
import com.ykh.conference.service.ConferenceService;
import com.ykh.conference.service.exception.CMSErrorCode;
import com.ykh.dao.conference.ConfJoinTempConfDao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.user.TempUserDao;
import com.ykh.dao.user.domain.TempUser;
import com.ykh.tang.agent.ICMSAgentInterface;
import com.ykh.tang.agent.vo.BMSUserInfo;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.user.service.UserConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserChannel joinUserInConf(Integer userId, Integer tempConferenceId) {
        TempUser tempUser= tempUserDao.findByUserId(userId);
        BMSUserInfo userInfo =new BMSUserInfo();

        if(tempUser!=null){
            Integer conft= tempUser.getTempConferenceId();
          ConfJoinTempConf confJoinTempConf= confJoinTempConfDao.findByTempConfId(tempConferenceId);
            if(confJoinTempConf!=null&&confJoinTempConf.getBmsStatus()!=2){
                RestException restException =new RestException();
                restException.setMessage(CMSErrorCode.CONFERENCE_NOT_FOUND.getDescription());
                restException.setErrorCode(CMSErrorCode.CONFERENCE_NOT_FOUND.value());
                throw  restException;
            }
            //
            if(conft!=tempConferenceId){
                icmsAgent.expelUser(Constants.site,conft, YkhUtils.getAllServicetypelist());
            }
        }else{
            tempUser = new TempUser();
        }

        UserChannel userChannel=  icmsAgent.userJoinConference(Constants.site,tempConferenceId,userInfo);
        tempUser.setPinCode(userInfo.pinCode);
        tempUser.setClientType(userInfo.getClientType());
        tempUser.setUserId(userId);
        tempUser.setTempConferenceId(tempConferenceId);
        tempUserDao.save(tempUser);
        userChannel.setTempConferenceID(tempConferenceId);
        userChannel.setUserID(userId);
        return userChannel;
    }
}
