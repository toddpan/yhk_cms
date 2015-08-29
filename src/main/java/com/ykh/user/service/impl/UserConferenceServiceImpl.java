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
import com.ykh.vo.req.UserConferenceRequest;
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
    public UserChannel userJoinConference(UserConferenceRequest request) {
        TempUser tempUser= tempUserDao.findByUserId(request.userID);
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
                icmsAgent.expelUser(Constants.site,conft, YkhUtils.getAllServicetypelist());
            }
        }else{
            tempUser = new TempUser();
        }
        tempUserDao.save(tempUser);
        userInfo.setDomain(request.getDomain());
        userInfo.setClientType(request.getClientType());
        userInfo.setUserID(tempUser.getIdTempUser());
        userInfo.setIPArr(request.getIpArr());
        userInfo.setPinCode(request.getPinCode());
        userInfo.setRoleTypeArr(request.getRoletypeArr());
        userInfo.setStatus(request.getStatus());

        UserChannel userChannel=  icmsAgent.userJoinConference(Constants.site,request.getTempConferenceId(),userInfo);
        tempUser.setPinCode(userInfo.pinCode);
        tempUser.setClientType(userInfo.getClientType());
        tempUser.setUserId(request.getUserID());
        tempUser.setTempConferenceId(request.getTempConferenceId());
        //修改
        tempUserDao.save(tempUser);
        userChannel.setTempConferenceID(request.getTempConferenceId());
        userChannel.setUserID(tempUser.getUserId());
        return userChannel;
    }
}
