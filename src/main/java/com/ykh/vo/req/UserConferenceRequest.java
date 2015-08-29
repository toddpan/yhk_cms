package com.ykh.vo.req;

import com.ykh.dao.user.domain.User;
import com.ykh.tang.agent.message.Ip;

import java.util.List;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class UserConferenceRequest {
    String applicationID;
    Integer tempConferenceId;
    public int userID; // 用户ID
    public String userName; // 用户名
    public int clientType; // 客户端类型，由应用设值
    public int pinCode; // PIN码
    public int domain; // 用户所在的域
    public int status; // 用户状态
    public List<String> ipArr; //IP列表
    public List<String> roletypeArr; // 用户的角色列表
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getDomain() {
        return domain;
    }

    public void setDomain(int domain) {
        this.domain = domain;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getIpArr() {
        return ipArr;
    }

    public void setIpArr(List<String> ipArr) {
        this.ipArr = ipArr;
    }

    public List<String> getRoletypeArr() {
        return roletypeArr;
    }

    public void setRoletypeArr(List<String> roletypeArr) {
        this.roletypeArr = roletypeArr;
    }
}
