package com.ykh.services.user;

import com.ykh.pojo.User;
import com.ykh.pojo.UserServiceDTO;


/**
 * Created by ant_shake_tree on 15/8/27.
 */
public interface UserConferenceService {
    UserServiceDTO userJoinConference(User request);
}
