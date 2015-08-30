package com.ykh.user.service;

import com.ykh.pojo.User;
import com.ykh.tang.agent.vo.UserChannel;


/**
 * Created by ant_shake_tree on 15/8/27.
 */
public interface UserConferenceService {
    UserChannel userJoinConference(User request);
}
