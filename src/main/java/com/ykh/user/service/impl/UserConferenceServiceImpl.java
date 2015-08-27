package com.ykh.user.service.impl;

import com.ykh.dao.user.TempUserDao;
import com.ykh.dao.user.domain.TempUser;
import com.ykh.tang.agent.ICMSAgentInterface;
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
    @Override
    public UserChannel joinUserInConf(Integer userId, Integer tempConferenceId) {
        TempUser tempUser= tempUserDao.findByUserId(userId);
//        if(tempUser!=null&&tempUser.get)
        //TODO temp user 不知道如何判断是否在其他会议当中
        return null;
    }
}
