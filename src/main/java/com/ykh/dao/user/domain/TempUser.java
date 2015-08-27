package com.ykh.dao.user.domain;

import javax.persistence.*;

/**
 * Created by ant_shake_tree on 15/8/24.
 */
@Table
@Entity
public class TempUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTempUser;

    private Integer userId;
    private  String username;
    private Integer clientType;
    private  Integer pinCode;
    private Integer tempConferenceId;
//    private domain" type="i"/>
//    <element name="status" type="u"/>
//    <element name="ip" type="au" size="4"/>
//    <element name="role_type" type="au"/>
//    <element name="time " type="t"/>


    public Integer getIdTempUser() {
        return idTempUser;
    }

    public void setIdTempUser(Integer idTempUser) {
        this.idTempUser = idTempUser;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public Integer getTempConferenceId() {
        return tempConferenceId;
    }

    public void setTempConferenceId(Integer tempConferenceId) {
        this.tempConferenceId = tempConferenceId;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}
