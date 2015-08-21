package com.ykh.vo.req;

import com.ykh.dao.user.domain.User;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class UserConferenceRequest {
    String applicationID;
    Integer tempConferenceID;
    User user;

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public Integer getTempConferenceID() {
        return tempConferenceID;
    }

    public void setTempConferenceID(Integer tempConferenceID) {
        this.tempConferenceID = tempConferenceID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
