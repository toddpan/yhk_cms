package com.ykh.vo.req;

import com.ykh.dao.user.domain.User;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class UserConferenceRequest {
    String applicationID;
    Integer tempConferenceId;
    Integer userId;

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public Integer getTempConferenceId() {
        return tempConferenceId;
    }

    public void setTempConferenceId(Integer tempConferenceId) {
        this.tempConferenceId = tempConferenceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
